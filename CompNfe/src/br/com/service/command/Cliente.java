package br.com.service.command;

import java.sql.SQLException;
import java.util.List;

import br.com.javac.bean.Usuario;
import br.com.javac.v200.nfe.TNFe;
import br.com.javac.v200.procnfe.TNfeProc;
import br.com.service.bean.Acesso;
import br.com.service.bean.Login;
import br.com.service.util.Perfil;
import br.com.service.util.StatusProcesso;
import br.com.vaccine.service.controller.ParseXml;
import br.com.vaccine.service.controller.Process;

public abstract class Cliente {
	protected String verificaPermissao(TNfeProc nfe, Usuario usr, ParseXml parse, Process processo, Login login) throws SQLException, Exception {
		String msg = null;		

			if (login.getCodPerfil()==Perfil.MASTER.ordinal()) {
				msg = perfilByCliente(nfe, usr, parse, processo, login,Perfil.MASTER.ordinal());
				
			 }else if(login.getCodPerfil()==Perfil.CLIENTE.ordinal()){	
				msg = perfilByCliente(nfe, usr, parse, processo, login,Perfil.CLIENTE.ordinal());
			
			} else if (login.getCodPerfil()==Perfil.USUARIO.ordinal()) {
				msg = perfilByUsuario(nfe, usr, parse, processo, login, msg,Perfil.USUARIO.ordinal());
				
		}
		//System.out.println(msg+"  abstract class Cliente.verificaPermissao()");
		return msg;
	}

	
	
	protected String verificaPermissao(TNFe nfe, Usuario usr, ParseXml parse, Process processo, Login login) throws SQLException, Exception {
		    String msg = null;			

			if (login.getCodPerfil()==Perfil.MASTER.ordinal()) {
				msg = perfilByCliente(nfe, usr, parse, processo, login,Perfil.MASTER.ordinal());
				
			 }else if(login.getCodPerfil()==Perfil.CLIENTE.ordinal()){
				msg = perfilByCliente(nfe, usr, parse, processo, login,Perfil.CLIENTE.ordinal());
			
			 }else if (login.getCodPerfil()==Perfil.USUARIO.ordinal()) {
				msg = perfilByUsuario(nfe, usr, parse, processo, login, msg,Perfil.USUARIO.ordinal());
		}
		return msg;
	}
	
	
	private String perfilByUsuario(TNfeProc nfe, Usuario usr, ParseXml parse, Process processo, Login login, String msg,int perfil) throws SQLException, Exception {
		
		Acesso acesso = processo.userWithAccess(login.getCodContrato(), login.getCodLogin());
		if (acesso == null) {
			msg = parse.criaXmlRetorno(StatusProcesso.USR_NOT.ordinal(), "Usuario sem permissao");
		} else if (acesso != null) {

			if (acesso.getCnpj().equalsIgnoreCase(nfe.getNFe().getInfNFe().getDest().getCNPJ()) || acesso.getCnpj().equalsIgnoreCase(nfe.getNFe().getInfNFe().getEmit().getCNPJ())) {
				msg = perfilByCliente(nfe, usr, parse, processo, login,perfil);
			} else {
				msg = parse.criaXmlRetorno(StatusProcesso.USR_NOT.ordinal(), "CNPJ nao liberado para este login");

			}
		}
		return msg;
	}	
	private String perfilByUsuario(TNFe nfe, Usuario usr, ParseXml parse, Process processo, Login login, String msg,int perfil) throws SQLException, Exception {
		
		Acesso acesso = processo.userWithAccess(login.getCodContrato(), login.getCodLogin());
		if (acesso == null) {
			msg = parse.criaXmlRetorno(StatusProcesso.USR_NOT.ordinal(), "Usuario sem permissao");
		} else if (acesso != null) {

			if (acesso.getCnpj().equalsIgnoreCase(nfe.getInfNFe().getDest().getCNPJ()) || acesso.getCnpj().equalsIgnoreCase(nfe.getInfNFe().getEmit().getCNPJ())) {
				msg = perfilByCliente(nfe, usr, parse, processo, login,perfil);
			} else {
				msg = parse.criaXmlRetorno(StatusProcesso.USR_NOT.ordinal(), "CNPJ nao liberado para este login");

			}
		}
		return msg;
	}
	
private String perfilByUsuario(TNfeProc nfe, Usuario usr, ParseXml parse, Process processo, Login login, String msg) throws SQLException, Exception {
		
		Acesso acesso = processo.userWithAccess(login.getCodContrato(), login.getCodLogin());
		if (acesso == null) {
			msg = parse.criaXmlRetorno(StatusProcesso.USR_NOT.ordinal(), "Usuario sem permissao");
		} else if (acesso != null) {

			if (acesso.getCnpj().equalsIgnoreCase(nfe.getNFe().getInfNFe().getDest().getCNPJ()) || acesso.getCnpj().equalsIgnoreCase(nfe.getNFe().getInfNFe().getEmit().getCNPJ())) {
				msg = perfilByCliente(nfe, usr, parse, processo, login,4);
			} else {
				msg = parse.criaXmlRetorno(StatusProcesso.USR_NOT.ordinal(), "CNPJ nao liberado para este login");

			}
		}
		return msg;
	}
	private String perfilByCliente(TNfeProc nfe, Usuario usr, ParseXml parse, Process processo, Login login,int perfil) throws SQLException, Exception ,NullPointerException{
		String msg;
		br.com.service.bean.Cliente cliente;
		List<br.com.service.bean.Cliente> clientes;
		clientes = processo.getClientesByContrato(login,perfil);
		cliente = StrategyCliente.strategyCliente(processo, clientes, nfe);
	
		if (cliente != null) {
			msg = processo.initProcesso(nfe, usr, parse, login, cliente);

		} else {
				msg = parse.criaXmlRetorno(StatusProcesso.CLI_NOT_CAD.ordinal(), "CNPJ nao cadastrado");
			
			}

		return msg;
	}
	
	private String perfilByCliente(TNFe nfe, Usuario usr, ParseXml parse, Process processo, Login login,int perfil) throws SQLException, Exception {
		String msg;
		br.com.service.bean.Cliente cliente;
		List<br.com.service.bean.Cliente> clientes;
		
		clientes = processo.getClientesByContrato(login,perfil);
		
		cliente = StrategyCliente.strategyCliente(processo, clientes, nfe);
		if (cliente != null) {
			msg = processo.initProcesso(nfe, usr, parse, login, cliente);

		} else {
			msg = parse.criaXmlRetorno(StatusProcesso.CLI_NOT_CAD.ordinal(), "Cliente nao cadastrado");
		}
		return msg;
	}
	

}
