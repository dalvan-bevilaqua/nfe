package br.com.service.common;

public enum ConfigValidention {
	
	VERSAO{String getString(){return "v0.9";}},
	CHARSET {String getString(){return "iso-8859-1";}},
	TMP_EXPIRA_TOKEN_LEMBRETE{String getString(){return "60";}},//TEMPO DE EXPIRAÇÃO DO TOKEN DE LEMBRETE DE SENHA
	TMP_EXPIRA_TOKEN_SESSION {String getString(){return "60";}},
	MSG_AUTHENTICADO {String getString(){return "USUARIO AUTENTICADO COM SUCESSO";}},
	MSG_VALIDATE{String getString(){return "USUARIO AUTENTICADO COM SUCESSO";}},	
	MSG_ERRO_99{String getString(){return "ERRO (-99) ERRO";}},
	MSG_ERRO_0{String getString(){return "ERRO (0) ERRO";}},	
	MSG_STATUS_99{String getString(){return "-1";}},
	MSG_STATUS_0{String getString(){return  "0";}};
	static final int RETURN_MAXIMO_REGISTROS = 500;
	
	abstract String getString();
}
