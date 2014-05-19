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
@Table(name = "tb_nfe_pis")
public class Pis implements Serializable {

	private static final long serialVersionUID = 42672780502603997L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PIS")
	private Long idPis;
	
	@OneToOne
	@JoinColumn(name = "NUM_PROT")
	@Cascade(value = { CascadeType.ALL })
	private Ide ide;
	
	@OneToOne
	@JoinColumn(name = "ID_ITEM")
	@Cascade(value = { CascadeType.ALL })
	private Prod iten;

	public Ide getIde() {
		return ide;
	}

	public void setIde(Ide ide) {
		this.ide = ide;
	}

	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vBC;
	@Column(length=2)
	private int CST;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vPIS;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pPIS;

	/*@OneToOne(mappedBy = "pis")
	// @JoinColumn(name = "ID_NFE_ITEN")
	@Cascade(value = { CascadeType.ALL })
	private Prod iten;*/
	
	public Long getIdPis() {
		return idPis;
	}

	public void setIdPis(Long idPis) {
		this.idPis = idPis;
	}

	public Prod getIten() {
		return iten;
	}

	public void setIten(Prod iten) {
		this.iten = iten;
	}

	public BigDecimal getvBC() {
		return vBC;
	}

	public void setvBC(BigDecimal vBC) {
		this.vBC = vBC;
	}

	public int getCST() {
		return CST;
	}

	public void setCST(int cST) {
		CST = cST;
	}

	public BigDecimal getvPIS() {
		return vPIS;
	}

	public void setvPIS(BigDecimal vPIS) {
		this.vPIS = vPIS;
	}

	public BigDecimal getpPIS() {
		return pPIS;
	}

	public void setpPIS(BigDecimal pPIS) {
		this.pPIS = pPIS;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
/*
	@Override
	public String toString() {
		return "Pis [idPis=" + idPis + ", vBC=" + vBC + ", CST=" + CST + ", vPIS=" + vPIS + ", pPIS=" + pPIS + ", iten=" + iten + "]";
	}*/

}
