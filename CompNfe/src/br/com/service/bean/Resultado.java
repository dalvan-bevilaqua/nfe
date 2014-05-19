package br.com.service.bean;

import java.io.Serializable;

public class Resultado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7583379391301078615L;
	private long numprot;
	private String Id;
	private String erroTipoId;
	private String nome;
	private String impEmis;
	private String critica;
	private String sugestao;


	public long getNumprot() {
		return numprot;
	}

	public void setNumprot(long numprot) {
		this.numprot = numprot;
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
