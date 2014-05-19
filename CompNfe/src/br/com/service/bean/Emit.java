package br.com.service.bean;

import java.io.Serializable;

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
@Table(name="tb_nfe_emit")
public class Emit implements Serializable{
	
	private static final long serialVersionUID = 4753931492688985540L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EMIT")
	private long idEmitente;
	
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
	@Column(length=14)
	private String cnpj;
	@Column(length=60)
	private String xNome;
	@Column(length=2)
	private String uf;
	@Column(length=14)
	private String ie;
	@Column
	private int crt;



	public int getCrt() {
		return crt;
	}

	public void setCrt(int crt) {
		this.crt = crt;
	}

	public long getIdEmitente() {
		return idEmitente;
	}

	public void setIdEmitente(long idEmitente) {
		this.idEmitente = idEmitente;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getxNome() {
		return xNome;
	}

	public void setxNome(String xNome) {
		this.xNome = xNome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}


	
}
