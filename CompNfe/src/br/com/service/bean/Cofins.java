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
@Table(name="tb_nfe_cofins")
public class Cofins implements Serializable {

	
	private static final long serialVersionUID = 2479362644723349763L;
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COFINS")
	private Long idCofins;	
	
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
	@Column(length=2)
	private int CST;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vBC;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal pCOFINS;
	@Column(columnDefinition = "DECIMAL(15,2)")
	private BigDecimal vCOFINS;
	
	
	
	/*@OneToOne(mappedBy="cofins")
	//@JoinColumn(name = "ID_NFE_ITEN")
	@Cascade(value = { CascadeType.ALL })
	private Prod iten;	*/
	
	    

	public Long getIdCofins() {
		return idCofins;
	}
	public void setIdCofins(Long idCofins) {
		this.idCofins = idCofins;
	}
	public Prod getIten() {
		return iten;
	}


	public void setIten(Prod iten) {
		this.iten = iten;
	}
	
	public int getCST() {
		return CST;
	}
	public void setCST(int cST) {
		CST = cST;
	}
	public BigDecimal getvBC() {
		return vBC;
	}
	public void setvBC(BigDecimal vBC) {
		this.vBC = vBC;
	}
	public BigDecimal getpCOFINS() {
		return pCOFINS;
	}
	public void setpCOFINS(BigDecimal pCOFINS) {
		this.pCOFINS = pCOFINS;
	}
	public BigDecimal getvCOFINS() {
		return vCOFINS;
	}
	public void setvCOFINS(BigDecimal vCOFINS) {
		this.vCOFINS = vCOFINS;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Cofins [idCofins=" + idCofins + ", CST=" + CST + ", vBC=" + vBC + ", pCOFINS=" + pCOFINS + ", vCOFINS=" + vCOFINS + ", iten=" + iten + "]";
	}

	
	
	
}
