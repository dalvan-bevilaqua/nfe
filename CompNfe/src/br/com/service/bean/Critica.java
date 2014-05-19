package br.com.service.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_nfe_critica")
public class Critica implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_NFE_CRIT")
	private Long idNfeCrit;
	@Column(name="NUM_PROT")
	private Long numProt;
	@Column(name="COD_FORM")
	private int codForm;
	@Column(name="TXT_1")
	private String txt1;
	@Column(name="TXT_2")
	private String txt2;
	@Column(name="TXT_3")
	private String txt3;
	@Column(name="TXT_4")
	private String txt4;
	@Column(name="TXT_5")
	private String txt5;
	@Column(name="TXT_6")
	private String txt6;
	@Column(name="TXT_7")
	private String txt7;
	@Column(name="TXT_8")
	private String txt8;
	@Column(name="TXT_9")
	private String txt9;
	@Column(name="TXT_10")
	private String txt10;
	public Long getIdNfeCrit() {
		return idNfeCrit;
	}
	public void setIdNfeCrit(Long idNfeCrit) {
		this.idNfeCrit = idNfeCrit;
	}
	public Long getNumProt() {
		return numProt;
	}
	public void setNumProt(Long numProt) {
		this.numProt = numProt;
	}
	public int getCodForm() {
		return codForm;
	}
	public void setCodForm(int codForm) {
		this.codForm = codForm;
	}
	public String getTxt1() {
		return txt1;
	}
	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}
	public String getTxt2() {
		return txt2;
	}
	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}
	public String getTxt3() {
		return txt3;
	}
	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}
	public String getTxt4() {
		return txt4;
	}
	public void setTxt4(String txt4) {
		this.txt4 = txt4;
	}
	public String getTxt5() {
		return txt5;
	}
	public void setTxt5(String txt5) {
		this.txt5 = txt5;
	}
	public String getTxt6() {
		return txt6;
	}
	public void setTxt6(String txt6) {
		this.txt6 = txt6;
	}
	public String getTxt7() {
		return txt7;
	}
	public void setTxt7(String txt7) {
		this.txt7 = txt7;
	}
	public String getTxt8() {
		return txt8;
	}
	public void setTxt8(String txt8) {
		this.txt8 = txt8;
	}
	public String getTxt9() {
		return txt9;
	}
	public void setTxt9(String txt9) {
		this.txt9 = txt9;
	}
	public String getTxt10() {
		return txt10;
	}
	public void setTxt10(String txt10) {
		this.txt10 = txt10;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
