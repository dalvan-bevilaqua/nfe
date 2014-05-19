package br.com.vaccine.service.controller;

import br.com.javac.bean.Usuario;
import br.com.javac.v200.nfe.TNFe;
import br.com.javac.v200.procnfe.TNfeProc;
import br.com.service.bean.Cliente;
import br.com.service.bean.Login;
import br.com.service.util.StatusProcesso;

public class ValidaOperacao implements Operacao {
    
	@Override
	public String validaOperByCnpj(TNfeProc proc, Usuario usr, String msg, ParseXml parse, Cliente cliente) throws Exception {
		if(cliente.getCnpj().equalsIgnoreCase(proc.getNFe().getInfNFe().getDest().getCNPJ())){
			if(usr.getIndOper()==1){
				msg = parse.criaXmlRetorno(StatusProcesso.CLI_NOT_CAD.ordinal(), " Favor verificar se a Nota é realmente relativa a uma ENTRADA, pois o CNPJ do DESTINATÁRIO, não consta em nosso cadastro");	
			}
		}else if(cliente.getCnpj().equalsIgnoreCase(proc.getNFe().getInfNFe().getEmit().getCNPJ())){
		   if(usr.getIndOper()==0){
			   msg = parse.criaXmlRetorno(StatusProcesso.CLI_NOT_CAD.ordinal(), "Favor verificar se a Nota é realmente relativa a uma SAÍDA, pois o CNPJ do EMITENTE, não consta em nosso cadastro");				
				}
		}
		return msg;
	}
	
	@Override
	public String verificaAutorizaoByCliente(TNFe nfe, Usuario usr, ParseXml parse, Process processo, Login login, Cliente cliente) throws Exception {
		String msg;
		if (cliente != null) {
			msg = processo.initProcesso(nfe, usr, parse, login, cliente);

		} else {
			msg = parse.criaXmlRetorno(StatusProcesso.CLI_NOT_CAD.ordinal(), "Cliente nao cadastrado");
		}
		return msg;
	}
	@Override
	public String verificaAutorizaoByCliente(TNfeProc proc, Usuario usr, ParseXml parse, Process processo, Login login, Cliente cliente) throws Exception {
		String msg;
		if (cliente != null) {
			msg = processo.initProcesso(proc, usr, parse, login, cliente);

		} else {
			msg = parse.criaXmlRetorno(StatusProcesso.CLI_NOT_CAD.ordinal(), "Cliente nao cadastrado");
		}
		return msg;
	}	
	
	@Override
	public String validaOperByCnpj(TNFe nfe, Usuario usr, String msg, ParseXml parse, Cliente cliente) throws Exception {
		if(cliente.getCnpj().equalsIgnoreCase(nfe.getInfNFe().getDest().getCNPJ())){
			if(usr.getIndOper()==1){
				msg = parse.criaXmlRetorno(StatusProcesso.CLI_NOT_CAD.ordinal(), " Favor verificar se a Nota é realmente relativa a uma ENTRADA, pois o CNPJ do DESTINATÁRIO, não consta em nosso cadastro");	
			}
		}else if(cliente.getCnpj().equalsIgnoreCase(nfe.getInfNFe().getEmit().getCNPJ())){
		   if(usr.getIndOper()==0){
			   msg = parse.criaXmlRetorno(StatusProcesso.CLI_NOT_CAD.ordinal(), " Favor verificar se a Nota é realmente relativa a uma SAÍDA, pois o CNPJ do EMITENTE, não consta em nosso cadastro");				
				}
		}
		return msg;
	}	
	

}
