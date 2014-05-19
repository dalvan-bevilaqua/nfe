package br.com.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.javac.v200.envinfe.TNFe;

@Entity
@Table(name = "tb_nfe_ide")
public class Ide implements Serializable {

	private static final long serialVersionUID = 8989869895834923686L;
	@Id
	@Column(name="NUM_PROT")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idIDe;
	
	@Column(name="dtProcesso")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dtProcesso = new GregorianCalendar();
	

	@OneToOne(mappedBy="ide")
	@Cascade(CascadeType.ALL)
	private Emit emit;
	
	@OneToOne(mappedBy="ide")
	@Cascade(CascadeType.ALL)
	private Dest dest;
	
	@OneToOne(mappedBy="ide")
	@Cascade(CascadeType.ALL)
	private Total total;
	
	
	@OneToMany(mappedBy = "ide", fetch=FetchType.LAZY)
    @Cascade(value = { CascadeType.ALL })
    private List<Prod> itens = new ArrayList<Prod>();	
	
	@OneToOne(mappedBy="ide")
	@Cascade(CascadeType.ALL)
	private Icms icms;
	
	@OneToOne(mappedBy="ide")
	@Cascade(CascadeType.ALL)
	private Cofins cofins;
	
	@OneToOne(mappedBy="ide")
	@Cascade(CascadeType.ALL)
	private Ipi ipi;
	
	@OneToOne(mappedBy="ide")
	@Cascade(CascadeType.ALL)
	private Pis pis;
	
	
	
	
	
	

	public Calendar getDtProcesso() {
		return dtProcesso;
	}

	public void setDtProcesso(Calendar dtProcesso) {
		this.dtProcesso = dtProcesso;
	}

	public Icms getIcms() {
		return icms;
	}

	public void setIcms(Icms icms) {
		this.icms = icms;
	}

	public Cofins getCofins() {
		return cofins;
	}

	public void setCofins(Cofins cofins) {
		this.cofins = cofins;
	}

	public Ipi getIpi() {
		return ipi;
	}

	public void setIpi(Ipi ipi) {
		this.ipi = ipi;
	}

	public Pis getPis() {
		return pis;
	}

	public void setPis(Pis pis) {
		this.pis = pis;
	}

	public List<Prod> getItens() {
		return itens;
	}

	public void setItens(List<Prod> itens) {
		this.itens = itens;
	}

	public Emit getEmit() {
		return emit;
	}

	public void setEmit(Emit emit) {
		this.emit = emit;
	}

	public Dest getDest() {
		return dest;
	}

	public void setDest(Dest dest) {
		this.dest = dest;
	}

	public Total getTotal() {
		return total;
	}

	public void setTotal(Total total) {
		this.total = total;
	}

	@Column(name = "COD_CONTRATO")
	private String codContrato;
	
	@Column(name = "COD_CONTRATO_CNPJ")
	private String codCli;
	
	@Column(name = "OPER",   length=1)
	private int oper;
	@Column(name = "chNFe",  length=100)
	private String chNFe;
	@Column(name = "serie", length=3)
	private String serie;	
	@Column(name = "nNF", length=9)
	private int nnf;

	private String dEmi;

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
	@Column(name="dSaiEnt")
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
	
	
	public String getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(String codContrato) {
		this.codContrato = codContrato;
	}

	public Long getIdIDe() {
		return idIDe;
	}

	public void setIdIDe(Long idIDe) {
		this.idIDe = idIDe;
	}

	public String getChNFe() {
		return chNFe;
	}

	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}


	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public int getOper() {
		return oper;
	}

	public void setOper(int oper) {
		this.oper = oper;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getNnf() {
		return nnf;
	}

	public void setNnf(int nnf) {
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
