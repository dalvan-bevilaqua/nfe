package br.com.service.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nfe_prod_sugestao")
public class ProdSugestao {

	@Id
	@Column(name = "ID_NFE_PROD_SUGESTAO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdCritica;
	@Column(name = "NUM_PROT")
	private Long numProt;
	@Column(name = "ID_NFE_PROD")
	private Long idNfeProd;
	private String chNFe;
	private String sugestao;
	
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
	public String getSugestao() {
		return sugestao;
	}
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	
}
