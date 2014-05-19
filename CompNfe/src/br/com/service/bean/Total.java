package br.com.service.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name="tb_nfe_total")

public class Total implements Serializable{

	private static final long serialVersionUID = 5356856510470475335L;	
	
	@Id
	@Column(name="ID_TOTAL")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idIde;
	
	@OneToOne
	@JoinColumn(name = "NUM_PROT")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Ide ide;
	
	
	public Ide getIde() {
		return ide;
	}
	public void setIde(Ide ide) {
		this.ide = ide;
	}
	@Column(name = "vBC",  columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vBC;
	@Column(name = "vICMS",  columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vICMS;
	@Column(name = "vST",  columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vST;
	@Column(name = "vProd",  columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vProd;
	@Column(name = "vIPI",  columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vIPI;
	@Column(name = "vPIS",  columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vPIS;
	@Column(name = "vCOFINS",  columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vCOFINS;
	@Column(name = "vNF",  columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vNF;
	
	
	
	

	public BigDecimal getvNF() {
		return vNF;
	}
	public void setvNF(BigDecimal vNF) {
		this.vNF = vNF;
	}
	public Long getIdIde() {
		return idIde;
	}
	public void setIdIde(Long idIde) {
		this.idIde = idIde;
	}
	public BigDecimal getvBC() {
		return vBC;
	}
	public void setvBC(BigDecimal vBC) {
		this.vBC = vBC;
	}
	public BigDecimal getvICMS() {
		return vICMS;
	}
	public void setvICMS(BigDecimal vICMS) {
		this.vICMS = vICMS;
	}
	public BigDecimal getvST() {
		return vST;
	}
	public void setvST(BigDecimal vST) {
		this.vST = vST;
	}
	public BigDecimal getvProd() {
		return vProd;
	}
	public void setvProd(BigDecimal vProd) {
		this.vProd = vProd;
	}
	public BigDecimal getvIPI() {
		return vIPI;
	}
	public void setvIPI(BigDecimal vIPI) {
		this.vIPI = vIPI;
	}
	public BigDecimal getvPIS() {
		return vPIS;
	}
	public void setvPIS(BigDecimal vPIS) {
		this.vPIS = vPIS;
	}
	public BigDecimal getvCOFINS() {
		return vCOFINS;
	}
	public void setvCOFINS(BigDecimal vCOFINS) {
		this.vCOFINS = vCOFINS;
	}

	
}
