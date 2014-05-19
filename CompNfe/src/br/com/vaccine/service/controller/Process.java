package br.com.vaccine.service.controller;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.com.javac.bean.Usuario;
import br.com.javac.v200.nfe.TNFe;
import br.com.javac.v200.procnfe.TNfeProc;
import br.com.service.bean.Acesso;
import br.com.service.bean.Cliente;
import br.com.service.bean.CriticaTO;
import br.com.service.bean.Login;
import br.com.service.bean.SugestaoTO;
import br.com.service.dao.HibernateDAO;
import br.com.service.util.Perfil;
import br.com.service.util.TypeFor;

public interface Process {      
 
	void totalLista(Document doc, Element retorno,int totalLista,String tipolista); 
	
    Login getContratoByLogin(Usuario usr) throws NoSuchAlgorithmException;
  	Cliente getClienteByClientes(List<Cliente> clientes ,String cnpj) throws SQLException;
  	List<Cliente> getClientesByContrato(Login login,int perfil) throws SQLException;
      
  	boolean saveDataXml(Serializable ser,HibernateDAO dao);
  	int executaFormulas(int codProduto,Long idIdentificacao,HibernateDAO dao,int codClasse,TypeFor typeFor);
  	List<CriticaTO> returnCriticas(Long idIdentificacao); 
  	List<SugestaoTO> returnSugestoes(Long idIdentificacao); 
  	
	String initProcesso(TNfeProc proc, Usuario usr, ParseXml parse, Login login, Cliente cli) throws Exception ;
	String initProcesso(TNFe nfe, Usuario usr, ParseXml parse, Login login, Cliente cli) throws Exception ;
	Acesso userWithAccess(int codContrato,int codLogin)throws SQLException;
	     
      
}
