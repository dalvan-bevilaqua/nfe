package br.com.service.bean;

public class Acesso {
	private String cnpj;
	private int perfil;
	private int codContrCnpjTipo;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public int getCodContrCnpjTipo() {
		return codContrCnpjTipo;
	}

	public void setCodContrCnpjTipo(int codContrCnpjTipo) {
		this.codContrCnpjTipo = codContrCnpjTipo;
	}

}
