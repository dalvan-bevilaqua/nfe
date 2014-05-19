package br.com.service.bean;

import javax.persistence.OneToOne;

public class NfeTotal{
	
	private String nfeId;
	private String vBC;
	private String vICMS;
	private String vST;
	private String vProd;
	private String vIPI;
	private String vPIS;
	private String vCOFINS;
	
	@OneToOne
	private NfeIde nfeIde;
	
	public String getNfeId() {
		return nfeId;
	}
	public void setNfeId(String nfeId) {
		this.nfeId = nfeId;
	}
	public String getvBC() {
		return vBC;
	}
	public void setvBC(String vBC) {
		this.vBC = vBC;
	}
	public String getvICMS() {
		return vICMS;
	}
	public void setvICMS(String vICMS) {
		this.vICMS = vICMS;
	}
	public String getvST() {
		return vST;
	}
	public void setvST(String vST) {
		this.vST = vST;
	}
	public String getvProd() {
		return vProd;
	}
	public void setvProd(String vProd) {
		this.vProd = vProd;
	}
	public String getvIPI() {
		return vIPI;
	}
	public void setvIPI(String vIPI) {
		this.vIPI = vIPI;
	}
	public String getvPIS() {
		return vPIS;
	}
	public void setvPIS(String vPIS) {
		this.vPIS = vPIS;
	}
	public String getvCOFINS() {
		return vCOFINS;
	}
	public void setvCOFINS(String vCOFINS) {
		this.vCOFINS = vCOFINS;
	}

	
}
