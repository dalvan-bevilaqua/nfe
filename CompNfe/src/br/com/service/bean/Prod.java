package br.com.service.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="tb_nfe_prod")
public class Prod implements Serializable{
	
	
	private static final long serialVersionUID = -6609738160887958824L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ITEM")
	private Long idItem;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROT")
	@Cascade(value = { CascadeType.ALL })
	private Ide ide;
	
	
	
	@Column(length=3)
	private String nItem;
	@Column(length=60)
	private String cProd;
	
	@Column(length=120)
	private String xProd;
	@Column(length=8)
	private String ncm;
	@Column(length=3)	
	private String extipi="";
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vProd;
	@Column(length=4)
	private String cfop;
	
	
	
	@OneToOne(mappedBy="iten")
	//@JoinColumn(name = "ID_PROD_ICMS")
	@Cascade(value = { CascadeType.ALL })	
	private Icms icms;
	
	@OneToOne(mappedBy="iten")
	//@JoinColumn(name = "ID_PROD_IPI")
	@Cascade(value = { CascadeType.ALL })
	private Ipi ipi;
	
	@OneToOne(mappedBy="iten")
	//@JoinColumn(name = "ID_PROD_PIS")
	@Cascade(value = { CascadeType.ALL })
	private Pis pis;
	
	@OneToOne(mappedBy="iten")
	//@JoinColumn(name = "ID_PROD_COFINS")
	@Cascade(value = { CascadeType.ALL })	
	private Cofins cofins;
	
	
	public Ipi getIpi() {
		return ipi;
	}
	public void setIpi(Ipi ipi) {
		this.ipi = ipi;
	}
	public Pis getPis() {
		return pis;
	}
	public void setPis(Pis pis) {
		this.pis = pis;
	}
	public Cofins getCofins() {
		return cofins;
	}
	public void setCofins(Cofins cofins) {
		this.cofins = cofins;
	}
	
	public Ide getIde() {
		return ide;
	}
	public void setIde(Ide ide) {
		this.ide = ide;
	}
	public Icms getIcms() {
		return icms;
	}
	public void setIcms(Icms icms) {
		this.icms = icms;
	}
	

	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
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
	public BigDecimal getvProd() {
		return vProd;
	}
	public void setvProd(BigDecimal vProd) {
		this.vProd = vProd;
	}
	public String getCfop() {
		return cfop;
	}
	public void setCfop(String cfop) {
		this.cfop = cfop;
	}
	
	
}