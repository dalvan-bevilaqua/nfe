package br.com.service.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.javac.v200.envinfe.TNFe;

@Entity
@Table(name="TB_NFE_IDE")

public class NfeIde {
	
	@Id
	@GeneratedValue
	private Long numProt;
	@Column(name="COD_CLI")
	private String codCli;
	@Column(name="OPER")
	private String oper;
	private String chNFe;
	
	public String getChNFe() {
		return chNFe;
	}
	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}
	public List<NfeProd> getList() {
		return list;
	}
	public void setList(List<NfeProd> list) {
		this.list = list;
	}
	private String serie;  
	@Column(name="nNF")
    private String nnf; 
	
    private String dEmi;
	
	@OneToMany(mappedBy="nfeId", fetch = FetchType.EAGER)
	private List<NfeProd> list;
	
	 @Transient
     private String cuf;   
	 @Transient
     private String cnf;
	 @Transient
     private String natOp;    
	 @Transient
     private String indPag;   
	 @Transient
     private String mod;    
     @Transient
     private String dSaiEnt;
     @Transient
     private String hSaiEnt;   
     @Transient
     private String tpNF;    
     @Transient
     private String cMunFG;  
     @Transient
     private List<TNFe.InfNFe.Ide.NFref> nFref;  
     @Transient
     private String tpImp;    
     @Transient
     private String tpEmis;    
     @Transient
     private String cdv;    
     @Transient
     private String tpAmb;  
     @Transient
     private String finNFe;    
     @Transient
     private String procEmi;  
     @Transient
     private String verProc;
     @Transient
     private String dhCont;
     @Transient
     private String xJust;
	public Long getNumProt() {
		return numProt;
	}
	public void setNumProt(Long numProt) {
		this.numProt = numProt;
	}
	public String getCodCli() {
		return codCli;
	}
	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getNnf() {
		return nnf;
	}
	public void setNnf(String nnf) {
		this.nnf = nnf;
	}
	public String getdEmi() {
		return dEmi;
	}
	public void setdEmi(String dEmi) {
		this.dEmi = dEmi;
	}
	public String getCuf() {
		return cuf;
	}
	public void setCuf(String cuf) {
		this.cuf = cuf;
	}
	public String getCnf() {
		return cnf;
	}
	public void setCnf(String cnf) {
		this.cnf = cnf;
	}
	public String getNatOp() {
		return natOp;
	}
	public void setNatOp(String natOp) {
		this.natOp = natOp;
	}
	public String getIndPag() {
		return indPag;
	}
	public void setIndPag(String indPag) {
		this.indPag = indPag;
	}
	public String getMod() {
		return mod;
	}
	public void setMod(String mod) {
		this.mod = mod;
	}
	public String getdSaiEnt() {
		return dSaiEnt;
	}
	public void setdSaiEnt(String dSaiEnt) {
		this.dSaiEnt = dSaiEnt;
	}
	public String gethSaiEnt() {
		return hSaiEnt;
	}
	public void sethSaiEnt(String hSaiEnt) {
		this.hSaiEnt = hSaiEnt;
	}
	public String getTpNF() {
		return tpNF;
	}
	public void setTpNF(String tpNF) {
		this.tpNF = tpNF;
	}
	public String getcMunFG() {
		return cMunFG;
	}
	public void setcMunFG(String cMunFG) {
		this.cMunFG = cMunFG;
	}
	public List<TNFe.InfNFe.Ide.NFref> getnFref() {
		return nFref;
	}
	public void setnFref(List<TNFe.InfNFe.Ide.NFref> nFref) {
		this.nFref = nFref;
	}
	public String getTpImp() {
		return tpImp;
	}
	public void setTpImp(String tpImp) {
		this.tpImp = tpImp;
	}
	public String getTpEmis() {
		return tpEmis;
	}
	public void setTpEmis(String tpEmis) {
		this.tpEmis = tpEmis;
	}
	public String getCdv() {
		return cdv;
	}
	public void setCdv(String cdv) {
		this.cdv = cdv;
	}
	public String getTpAmb() {
		return tpAmb;
	}
	public void setTpAmb(String tpAmb) {
		this.tpAmb = tpAmb;
	}
	public String getFinNFe() {
		return finNFe;
	}
	public void setFinNFe(String finNFe) {
		this.finNFe = finNFe;
	}
	public String getProcEmi() {
		return procEmi;
	}
	public void setProcEmi(String procEmi) {
		this.procEmi = procEmi;
	}
	public String getVerProc() {
		return verProc;
	}
	public void setVerProc(String verProc) {
		this.verProc = verProc;
	}
	public String getDhCont() {
		return dhCont;
	}
	public void setDhCont(String dhCont) {
		this.dhCont = dhCont;
	}
	public String getxJust() {
		return xJust;
	}
	public void setxJust(String xJust) {
		this.xJust = xJust;
	}
	
	
	
	
	
}
