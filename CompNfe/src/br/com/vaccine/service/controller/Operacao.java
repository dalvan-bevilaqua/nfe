package br.com.vaccine.service.controller;

import br.com.javac.bean.Usuario;
import br.com.javac.v200.nfe.TNFe;
import br.com.javac.v200.procnfe.TNfeProc;
import br.com.service.bean.Cliente;
import br.com.service.bean.Login;

public interface Operacao {
	
	String verificaAutorizaoByCliente(TNfeProc proc, Usuario usr, ParseXml parse, Process processo, Login login, Cliente cliente) throws Exception;
	String verificaAutorizaoByCliente(TNFe nfe, Usuario usr, ParseXml parse, Process processo, Login login, Cliente cliente) throws Exception;
	String validaOperByCnpj(TNfeProc proc, Usuario usr, String msg, ParseXml parse, Cliente cliente) throws Exception ;	
	String validaOperByCnpj(TNFe nfe, Usuario usr, String msg, ParseXml parse, Cliente cliente) throws Exception ;

}


