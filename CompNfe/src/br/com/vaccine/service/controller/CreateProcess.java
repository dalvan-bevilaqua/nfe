package br.com.vaccine.service.controller;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.com.javac.bean.Usuario;
import br.com.javac.v200.nfe.TNFe;
import br.com.javac.v200.procnfe.TNfeProc;
import br.com.service.bean.Acesso;
import br.com.service.bean.Cliente;
import br.com.service.bean.CriticaTO;
import br.com.service.bean.Ide;
import br.com.service.bean.Logger;
import br.com.service.bean.Login;
import br.com.service.bean.SugestaoTO;
import br.com.service.common.SHA256;
import br.com.service.dao.ClienteDAO;
import br.com.service.dao.HibernateDAO;
import br.com.service.dao.JdbcDAO;
import br.com.service.util.Perfil;
import br.com.service.util.TypeFor;

public class CreateProcess extends AbstractProcess implements Process {
	private Config config = new InitProcess();
	@Override
	public String initProcesso(TNfeProc proc, Usuario usr, ParseXml parse, Login login, Cliente cli) throws Exception {
		String msg = null;
		LoadDadosXml load;
		Ide ide;
		load = new LoadDadosXml();
		Process processo = new CreateProcess();
		HibernateDAO dao = new HibernateDAO();
		ide = load.loadDados(proc, usr, login, cli);

		try {
			if (usr.getIndOper() > 1 || usr.getIndOper() < 0 ){
			msg = parse.criaXmlRetorno(-2, "indOper "+usr.getIndOper() +" invalido utilize 0 para operacao de entrada e 1 para operacao de saida");
		
		}else{
			processo.saveDataXml(ide, dao);			
		    msg = config.operationInput(usr, parse, msg, ide, processo, dao);
		}

		} catch (Exception e) {
			msg = parse.criaXmlRetorno(-1,getClass()+"initProcesso TNfeProc"+ e.getMessage());
		}
		return msg;
	}

	@Override
	public String initProcesso(TNFe nfe, Usuario usr, ParseXml parse, Login login, Cliente cli) throws Exception {
		String msg = null;
		LoadDadosXml load;
		Ide ide;
		load = new LoadDadosXml();
		Process processo = new CreateProcess();
		HibernateDAO dao = new HibernateDAO();
		List<CriticaTO> criticas = null;
		ide = load.loadDados(nfe, usr, login, cli);

		try {
			processo.saveDataXml(ide, dao);
			/*processo.executaFormulas(config.PRODUTO_VACCINE_NFE, ide.getIdIDe(), dao, usr.getIndOper(), setTypeOper(usr));
			criticas = processo.returnCriticas(ide.getIdIDe());
			msg = parse.criaXmlRetCri(ide, criticas);*/
			msg = config.operationInput(usr, parse, msg, ide, processo, dao);

		} catch (Exception e) {
			msg = parse.criaXmlRetorno(-1,getClass()+"initProcesso ]TNFe"+ e.getMessage());
		}
		return msg;
	}	

	@Override
	public Login getContratoByLogin(Usuario usr) throws NoSuchAlgorithmException, HibernateException {
		Login login = null;
		ClienteDAO aut = new HibernateDAO();
		try {
			//System.out.println("consult usr "+getClass()+"getContratoByLogin(Usuario usr)"+usr.getPwd());
			login = aut.consultaUsuario(usr.getUsr(), String.valueOf(SHA256.encrypt(usr.getPwd())));			
			if(login==null){
				//System.out.println("encript is null ");
				login = aut.consultaUsuario(usr.getUsr(), usr.getPwd());
			}
			
		} catch (HibernateException e) {
			Logger.log("ERRO " + getClass(), e.getMessage());
			throw e;
		} catch (NullPointerException e) {
			Logger.log("ERRO " + getClass(), e.getMessage());
			throw new NullPointerException(e.getMessage()+"  "+getClass()+"getContratoByLogin(Usuario usr)");
		}

		return login;
	}

	@Override
	public List<Cliente> getClientesByContrato(Login login,int perfil) throws SQLException {
		JdbcDAO dao = new JdbcDAO();
		//System.out.println("chamou o dao");
		return dao.clientesByContrato(login.getCodContrato(),perfil);
	}

	@Override
	public Cliente getClienteByClientes(List<Cliente> clientes, String cnpj) throws SQLException {
		Cliente cliente = null;
		for (Cliente cli : clientes) {
			if (cli.getCnpj().equalsIgnoreCase(cnpj)) {
				cliente = cli;
				break;
			}

		}
		return cliente;
	}


	@Override
	public void totalLista(Document doc, Element retorno, int totalLista, String tipolista) {
		Element qtdeCriticas = doc.createElement(tipolista);
		qtdeCriticas.appendChild(doc.createTextNode(String.valueOf(totalLista)));
		retorno.appendChild(qtdeCriticas);

	}

	@Override
	public boolean saveDataXml(Serializable ser, HibernateDAO dao) {
		boolean okay = false;
		try {
			okay = dao.persistDao(ser);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return okay;
	}

	@Override
	public int executaFormulas(int codProduto, Long idIdentificacao, HibernateDAO dao, int codClasse, TypeFor typeFor) {
		Formula formula = new ExecutaFormula();
		int okay = 0;
		try {
			okay = formula.processarFormulas(codProduto, idIdentificacao, dao, codClasse, typeFor);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return okay;
	}

	@Override
	public List<CriticaTO> returnCriticas(Long idIdentificacao) {
		List<CriticaTO> criticas = null;
		JdbcDAO dao = new JdbcDAO();
		try {
			criticas = dao.getReview(idIdentificacao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return criticas;
	}

	@Override
	public List<SugestaoTO> returnSugestoes(Long idIdentificacao) {
		List<SugestaoTO> sugestoes = null;
		JdbcDAO dao = new JdbcDAO();
		try {
			sugestoes = dao.getSuggestions(idIdentificacao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sugestoes;
	}

	@Override
	public Acesso userWithAccess(int codContrato, int codLogin) throws SQLException {
		JdbcDAO dao = new JdbcDAO();
		return dao.userWithAccess(codContrato, codLogin);
	}
	
	
}
