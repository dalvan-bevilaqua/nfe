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
@Table(name="tb_nfe_dest")
public class Dest implements Serializable{

	private static final long serialVersionUID = -5502001567676464131L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DEST")
	private long idDestinatario;
	
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
	@Column(length=11)
	private String cpf;
	@Column(length=60)
	private String xNome;
	@Column(length=2)
	private String UF;
	@Column(length=14)
	private String IE;	
	




	public String getCnpj() {
		return cnpj;
	}

	public long getIdDestinatario() {
		return idDestinatario;
	}


	public void setIdDestinatario(long idDestinatario) {
		this.idDestinatario = idDestinatario;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getxNome() {
		return xNome;
	}

	public void setxNome(String xNome) {
		this.xNome = xNome;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}


	
}
