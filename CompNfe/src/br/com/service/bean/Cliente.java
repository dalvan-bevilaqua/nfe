package br.com.service.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tb_sys_contrato_cnpj")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 744973233132901300L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_CONTRATO_CNPJ")
	private int codContratoCnpj;
	
	@Column(name = "COD_CONTRATO_CNPJ_TIPO")
	private int codContratoCnpjTipo;
	@Column(name = "COD_MATRIZ")
	private int codMatriz;
	@Column(name = "CNPJ")
	private String cnpj;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "qtd_vac_aut")
	private int qtdeVacAut;
	@Column(name = "qtd_vac_utili")
	private int qtdeVacUtili;	
	@Column(name = "JAN")
	private int mesJan;
	@Column(name = "FEV")
	private int mesFev;
	@Column(name = "MAR")
	private int mesMarc;
	@Column(name = "ABR")
	private int mesAbri;
	@Column(name = "MAI")
	private int mesMai;
	@Column(name = "JUN")
	private int mesJun;
	@Column(name = "JUL")
	private int mesJul;
	@Column(name = "AGO")
	private int mesAgo;
	@Column(name = "SET")
	private int mesSet;
	@Column(name = "OUT")
	private int mesOut;
	@Column(name = "NOV")
	private int mesNov;
	@Column(name = "DEZ")
	private int mesDez;
	
	
	@ManyToOne
	@JoinColumn(name = "COD_CONTRATO")
	@Cascade(value = { CascadeType.ALL })
	private Contrato cont;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Contrato getCont() {
		return cont;
	}

	public void setCont(Contrato cont) {
		this.cont = cont;
	}
	public int getCodContratoCnpj() {
		return codContratoCnpj;
	}

	public void setCodContratoCnpj(int codContratoCnpj) {
		this.codContratoCnpj = codContratoCnpj;
	}

	/*public int getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}*/

	public int getCodContratoCnpjTipo() {
		return codContratoCnpjTipo;
	}

	public void setCodContratoCnpjTipo(int codContratoCnpjTipo) {
		this.codContratoCnpjTipo = codContratoCnpjTipo;
	}

	public int getCodMatriz() {
		return codMatriz;
	}

	public void setCodMatriz(int codMatriz) {
		this.codMatriz = codMatriz;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdeVacAut() {
		return qtdeVacAut;
	}

	public void setQtdeVacAut(int qtdeVacAut) {
		this.qtdeVacAut = qtdeVacAut;
	}

	public int getQtdeVacUtili() {
		return qtdeVacUtili;
	}

	public void setQtdeVacUtili(int qtdeVacUtili) {
		this.qtdeVacUtili = qtdeVacUtili;
	}

	public int getMesJan() {
		return mesJan;
	}

	public void setMesJan(int mesJan) {
		this.mesJan = mesJan;
	}

	public int getMesFev() {
		return mesFev;
	}

	public void setMesFev(int mesFev) {
		this.mesFev = mesFev;
	}

	public int getMesMarc() {
		return mesMarc;
	}

	public void setMesMarc(int mesMarc) {
		this.mesMarc = mesMarc;
	}

	public int getMesAbri() {
		return mesAbri;
	}

	public void setMesAbri(int mesAbri) {
		this.mesAbri = mesAbri;
	}

	public int getMesMai() {
		return mesMai;
	}

	public void setMesMai(int mesMai) {
		this.mesMai = mesMai;
	}

	public int getMesJun() {
		return mesJun;
	}

	public void setMesJun(int mesJun) {
		this.mesJun = mesJun;
	}

	public int getMesJul() {
		return mesJul;
	}

	public void setMesJul(int mesJul) {
		this.mesJul = mesJul;
	}

	public int getMesAgo() {
		return mesAgo;
	}

	public void setMesAgo(int mesAgo) {
		this.mesAgo = mesAgo;
	}

	public int getMesSet() {
		return mesSet;
	}

	public void setMesSet(int mesSet) {
		this.mesSet = mesSet;
	}

	public int getMesOut() {
		return mesOut;
	}

	public void setMesOut(int mesOut) {
		this.mesOut = mesOut;
	}

	public int getMesNov() {
		return mesNov;
	}

	public void setMesNov(int mesNov) {
		this.mesNov = mesNov;
	}

	public int getMesDez() {
		return mesDez;
	}

	public void setMesDez(int mesDez) {
		this.mesDez = mesDez;
	}


	@Override
	public String toString() {
		return "Cliente [codContratoCnpj=" + codContratoCnpj + ", codContratoCnpjTipo=" + codContratoCnpjTipo + ", codMatriz=" + codMatriz + ", cnpj=" + cnpj + ", nome=" + nome + ", qtdeVacAut=" + qtdeVacAut + ", qtdeVacUtili=" + qtdeVacUtili + ", mesJan=" + mesJan + ", mesFev=" + mesFev + ", mesMarc=" + mesMarc + ", mesAbri=" + mesAbri + ", mesMai="
				+ mesMai + ", mesJun=" + mesJun + ", mesJul=" + mesJul + ", mesAgo=" + mesAgo + ", mesSet=" + mesSet + ", mesOut=" + mesOut + ", mesNov=" + mesNov + ", mesDez=" + mesDez + ", cont=" + cont + "]";
	}

}
