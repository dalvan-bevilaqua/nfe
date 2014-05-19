package br.com.service.bean;

public class NfeResultado {

	private String nfeId;
	private String Id;
	private String erroTipoId;
	private String nome;
	private String impEmis;
	private String critica;
	private String sugestao;

	public String getNfeId() {
		return nfeId;
	}

	public void setNfeId(String nfeId) {
		this.nfeId = nfeId;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getErroTipoId() {
		return erroTipoId;
	}

	public void setErroTipoId(String erroTipoId) {
		this.erroTipoId = erroTipoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImpEmis() {
		return impEmis;
	}

	public void setImpEmis(String impEmis) {
		this.impEmis = impEmis;
	}

	public String getCritica() {
		return critica;
	}

	public void setCritica(String critica) {
		this.critica = critica;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

}
