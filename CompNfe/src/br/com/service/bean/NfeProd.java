package br.com.service.bean;

import java.util.List;

public class NfeProd {

	private String nfeId;
	private String itemId;
	private String nItem;
	private String cProd;
	private String xProd;
	private String ncm;
	private String extipi;
	private String vProd;
	private String cfop;
	
	private List<Imposto> impostos;
	
	
	
	public String getNfeId() {
		return nfeId;
	}
	public void setNfeId(String nfeId) {
		this.nfeId = nfeId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getnItem() {
		return nItem;
	}
	public void setnItem(String nItem) {
		this.nItem = nItem;
	}
	public String getcProd() {
		return cProd;
	}
	public void setcProd(String cProd) {
		this.cProd = cProd;
	}
	public String getxProd() {
		return xProd;
	}
	public void setxProd(String xProd) {
		this.xProd = xProd;
	}
	public String getNcm() {
		return ncm;
	}
	public void setNcm(String ncm) {
		this.ncm = ncm;
	}
	public String getExtipi() {
		return extipi;
	}
	public void setExtipi(String extipi) {
		this.extipi = extipi;
	}
	public String getvProd() {
		return vProd;
	}
	public void setvProd(String vProd) {
		this.vProd = vProd;
	}
	public String getCfop() {
		return cfop;
	}
	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	
	
}