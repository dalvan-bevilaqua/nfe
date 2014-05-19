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
@Table(name="tb_nfe_ipi")
public class Ipi implements Serializable {

	private static final long serialVersionUID = 4144628666991248212L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_IPI")
	private Long idIpi;
	
	@OneToOne
	@JoinColumn(name = "NUM_PROT")
	@Cascade(value = { CascadeType.ALL })
	private Ide ide;
	
	public Ide getIde() {
		return ide;
	}
	public void setIde(Ide ide) {
		this.ide = ide;
	}
	@OneToOne
	@JoinColumn(name = "ID_ITEM")
	@Cascade(value = { CascadeType.ALL })
	private Prod iten;	
	
	@Column(length=2)
	private String CST;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vBC;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pIPI;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vIPI;
	public Long getIdIpi() {
		return idIpi;
	}
	public void setIdIpi(Long idIpi) {
		this.idIpi = idIpi;
	}
	public Prod getIten() {
		return iten;
	}
	public void setIten(Prod iten) {
		this.iten = iten;
	}
	public String getCST() {
		return CST;
	}
	public void setCST(String cST) {
		CST = cST;
	}
	public BigDecimal getvBC() {
		return vBC;
	}
	public void setvBC(BigDecimal vBC) {
		this.vBC = vBC;
	}
	public BigDecimal getpIPI() {
		return pIPI;
	}
	public void setpIPI(BigDecimal pIPI) {
		this.pIPI = pIPI;
	}
	public BigDecimal getvIPI() {
		return vIPI;
	}
	public void setvIPI(BigDecimal vIPI) {
		this.vIPI = vIPI;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	
}
