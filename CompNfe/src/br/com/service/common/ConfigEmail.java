package br.com.service.common;

public enum ConfigEmail {
	EMAIL_SMTP{String getString(){return "smtp.gmail.com";}},
    EMAIL_FROM{String getString(){return "alertas@ntk.com.br";}},
    EMAIL_EMAIL{String getString(){return "alertas@ntk.com.br";}},
    EMAIL_SENHA{String getString(){return "solutions2008";}};
   
    
    static final String[][] EMAIL_CC = {		
		{"Ricardo","ricardo.almeida@ntk.com.br"},
		{"Thiago","santos.thiago@ntk.com.br"},
		{"Catia","catia@ntk.com.br"}
	};
    
    /* EMAIL_SSL{return true},
    EMAIL_SET_DEBUG{String getString(){return true;}};     
	  */
   
	abstract String getString();
	

}
