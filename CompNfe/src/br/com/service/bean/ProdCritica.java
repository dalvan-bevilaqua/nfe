package br.com.service.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nfe_prod_critica")
public class ProdCritica {

	@Id
	@Column(name = "ID_NFE_PROD_CRITICA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdCritica;
	@Column(name = "NUM_PROT")
	private Long numProt;
	@Column(name = "ID_NFE_PROD")
	private Long idNfeProd;
	private String chNFe;
	private String critica;

	public Long getIdProdCritica() {
		return idProdCritica;
	}

	public void setIdProdCritica(Long idProdCritica) {
		this.idProdCritica = idProdCritica;
	}

	public Long getNumProt() {
		return numProt;
	}

	public void setNumProt(Long numProt) {
		this.numProt = numProt;
	}

	public Long getIdNfeProd() {
		return idNfeProd;
	}

	public void setIdNfeProd(Long idNfeProd) {
		this.idNfeProd = idNfeProd;
	}

	public String getChNFe() {
		return chNFe;
	}

	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}

	public String getCritica() {
		return critica;
	}

	public void setCritica(String critica) {
		this.critica = critica;
	}

}
