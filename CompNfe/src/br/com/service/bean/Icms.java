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
import org.hibernate.annotations.CascadeType;
@Entity
@Table(name="tb_nfe_icms")
public class Icms implements  Serializable {
	

	private static final long serialVersionUID = -8743915121714416543L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ICMS")
	private Long idICms;
	
	@OneToOne
	@JoinColumn(name = "NUM_PROT")
	@Cascade(value = { CascadeType.ALL })
	private Ide ide;
	
	@OneToOne
	@JoinColumn(name = "ID_ITEM")	
	@Cascade(value = { CascadeType.ALL })
	private Prod iten;	
	
	@Column(length=2)
	private String CST;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pBC;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vBC;
	@Column(length=1)
	private int orig;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pICMS;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vICMS;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vBCST;
	@Column(columnDefinition = "DECIMAL(5,2)")	
	private BigDecimal pICMSST;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vICMSST;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pCredSN;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vCredICMSSN;
	@Column(length=255)
	private String cSOSN;
	@Column(length=1)
	private int modBCST;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pRedBCST;
	@Column(columnDefinition = "DECIMAL(19,2)")
	private BigDecimal vRedBCST;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pMVAST;
	@Column(columnDefinition = "DECIMAL(15,2)")	
	private BigDecimal vBCSTRet;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal vICMSSTRet;
	@Column(length=1)
	/*private BigDecimal pPMVAST;
	@Column*/
	private int modBC;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pRedBC;
	
	    
	
	
	
	public Ide getIde() {
		return ide;
	}


	public void setIde(Ide ide) {
		this.ide = ide;
	}


	public Prod getIten() {
		return iten;
	}


	public void setIten(Prod iten) {
		this.iten = iten;
	}


	public long getIdICms() {
		return idICms;
	}


	public void setIdICms(Long idICms) {
		this.idICms = idICms;
	}

	public void setIdICms(long idICms) {
		this.idICms = idICms;
	}

	

	public BigDecimal getpRedBC() {
		return pRedBC;
	}

	public void setpRedBC(BigDecimal pRedBC) {
		this.pRedBC = pRedBC;
	}

	public BigDecimal getvICMSSTRet() {
		return vICMSSTRet;
	}

	public void setvICMSSTRet(BigDecimal vICMSSTRet) {
		this.vICMSSTRet = vICMSSTRet;
	}

	public BigDecimal getvRedBCST() {
		return vRedBCST;
	}

	public void setvRedBCST(BigDecimal vRedBCST) {
		this.vRedBCST = vRedBCST;
	}

	public BigDecimal getvBCSTRet() {
		return vBCSTRet;
	}

	public void setvBCSTRet(BigDecimal vBCSTRet) {
		this.vBCSTRet = vBCSTRet;
	}	

	public BigDecimal getpCredSN() {
		return pCredSN;
	}

	public void setpCredSN(BigDecimal pCredSN) {
		this.pCredSN = pCredSN;
	}

	public BigDecimal getvCredICMSSN() {
		return vCredICMSSN;
	}

	public void setvCredICMSSN(BigDecimal vCredICMSSN) {
		this.vCredICMSSN = vCredICMSSN;
	}

	public String getcSOSN() {
		return cSOSN;
	}

	public void setcSOSN(String cSOSN) {
		this.cSOSN = cSOSN;
	}

	

	public int getModBCST() {
		return modBCST;
	}


	public void setModBCST(int modBCST) {
		this.modBCST = modBCST;
	}


	public int getModBC() {
		return modBC;
	}


	public void setModBC(int modBC) {
		this.modBC = modBC;
	}


	public BigDecimal getpRedBCST() {
		return pRedBCST;
	}

	public void setpRedBCST(BigDecimal pRedBCST) {
		this.pRedBCST = pRedBCST;
	}

	public BigDecimal getpMVAST() {
		return pMVAST;
	}

	public void setpMVAST(BigDecimal pMVAST) {
		this.pMVAST = pMVAST;
	}

	/*public IcmsTrib getIcmsTrib() {
		return icmsTrib;
	}

	public void setIcmsTrib(IcmsTrib icmsTrib) {
		this.icmsTrib = icmsTrib;
	}*/

	public String getCST() {
		return CST;
	}

	public void setCST(String cST) {
		CST = cST;
	}

	public BigDecimal getpBC() {
		return pBC;
	}

	public void setpBC(BigDecimal pBC) {
		this.pBC = pBC;
	}

	public BigDecimal getvBC() {
		return vBC;
	}

	public void setvBC(BigDecimal vBC) {
		this.vBC = vBC;
	}

	public int getOrig() {
		return orig;
	}

	public void setOrig(int orig) {
		this.orig = orig;
	}

	public BigDecimal getpICMS() {
		return pICMS;
	}

	public void setpICMS(BigDecimal pICMS) {
		this.pICMS = pICMS;
	}

	public BigDecimal getvICMS() {
		return vICMS;
	}

	public void setvICMS(BigDecimal vICMS) {
		this.vICMS = vICMS;
	}

	public BigDecimal getvBCST() {
		return vBCST;
	}

	public void setvBCST(BigDecimal vBCST) {
		this.vBCST = vBCST;
	}

	public BigDecimal getpICMSST() {
		return pICMSST;
	}

	public void setpICMSST(BigDecimal pICMSST) {
		this.pICMSST = pICMSST;
	}

	public BigDecimal getvICMSST() {
		return vICMSST;
	}

	public void setvICMSST(BigDecimal vICMSST) {
		this.vICMSST = vICMSST;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
