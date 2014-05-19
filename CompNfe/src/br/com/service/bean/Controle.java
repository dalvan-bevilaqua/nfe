package br.com.service.bean;

import java.io.Serializable;

public class Controle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7579966543515984590L;
	private String cliId;
	private String numProt;
	private String Id;
	private String dtProc;
	private String impEmiss;
	private String ip;

	public String getCliId() {
		return cliId;
	}

	public void setCliId(String cliId) {
		this.cliId = cliId;
	}



	public String getNumProt() {
		return numProt;
	}

	public void setNumProt(String numProt) {
		this.numProt = numProt;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDtProc() {
		return dtProc;
	}

	public void setDtProc(String dtProc) {
		this.dtProc = dtProc;
	}

	public String getImpEmiss() {
		return impEmiss;
	}

	public void setImpEmiss(String impEmiss) {
		this.impEmiss = impEmiss;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
