package br.com.vaccine.service.controller;

import br.com.javac.bean.Usuario;
import br.com.service.bean.Ide;
import br.com.service.dao.HibernateDAO;

public interface Config {
	 
	 static final int PRODUTO_VACCINE_NFE = 8;
	 static final int CLASSE_CRITICA=0;
	 static final int CLASSE_SUGESTAO=1;
	 boolean validTypeOper(Ide nf,int total);
	 static final int NFE_SAIDA=1;
	 static final int NFE_ENTRADA=0;
    String operationInput(Usuario usr, ParseXml parse, String msg, Ide ide, Process processo, HibernateDAO dao) throws Exception ;
	


}
