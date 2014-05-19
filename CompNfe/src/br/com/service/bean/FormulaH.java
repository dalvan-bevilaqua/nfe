package br.com.service.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_sys_formula")
public class FormulaH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = " COD_FORMULA ")
	private Long codFormula;

	@Column(name = "COD_PRODUTO ")
	private int codProduto;

	@Column(name = " NOM_FORMULA")
	private String monFormula;

	@Column(name = " COD_CLASSE")
	private int codClasse;

	@Column(name = " CLASSE ")
	private String classe;

	@Column(name = " SUM_CLASSE")
	private String sumClasse;

	@Column(name = " TXT_LEGAL ")
	private String txtLegal;

	@Column(name = " STATUS_FORMULA")
	private String statusFormula;

	@Column(name = " TXT_SQL ")
	private String txtSql;

	@Column(name = "TXT_COL1 ")
	private String txtCol1;

	@Column(name = " TXT_COL2")
	private String txtCol2;

	@Column(name = " TXT_COL3")
	private String txtCol3;

	@Column(name = "TXT_COL4 ")
	private String txtCol4;

	@Column(name = "  TXT_COL5")
	private String txtCol5;

	@Column(name = "TXT_COL6 ")
	private String txtCol6;

	@Column(name = "TXT_COL7 ")
	private String txtCol7;

	@Column(name = "TXT_COL8 ")
	private String txtCol8;

	@Column(name = "TXT_COL9 ")
	private String txtCol9;

	@Column(name = "TXT_COL10")
	private String txtCol10;

	@Column(name = "TXT_COL11 ")
	private String txtCol11;

	@Column(name = "TXT_COL12 ")
	private String txtCol12;

	@Column(name = "TXT_COL13 ")
	private String txtCol13;

	@Column(name = "TXT_COL14 ")
	private String txtCol14;

	@Column(name = "TXT_COL15 ")
	private String txtCol15;

	@Column(name = "IN_REPORT")
	private String inReport;

	@Column(name = "COMP_FINC")
	private String compFinc;

	/*public Long getIdFormula() {
		return idFormula;
	}

	public void setIdFormula(Long idFormula) {
		this.idFormula = idFormula;
	}*/

	public Long getCodFormula() {
		return codFormula;
	}

	public void setCodFormula(Long codFormula) {
		this.codFormula = codFormula;
	}

	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public String getMonFormula() {
		return monFormula;
	}

	public void setMonFormula(String monFormula) {
		this.monFormula = monFormula;
	}

	public int getCodClasse() {
		return codClasse;
	}

	public void setCodClasse(int codClasse) {
		this.codClasse = codClasse;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getSumClasse() {
		return sumClasse;
	}

	public void setSumClasse(String sumClasse) {
		this.sumClasse = sumClasse;
	}

	public String getTxtLegal() {
		return txtLegal;
	}

	public void setTxtLegal(String txtLegal) {
		this.txtLegal = txtLegal;
	}

	public String getStatusFormula() {
		return statusFormula;
	}

	public void setStatusFormula(String statusFormula) {
		this.statusFormula = statusFormula;
	}

	public String getTxtSql() {
		return txtSql;
	}

	public void setTxtSql(String txtSql) {
		this.txtSql = txtSql;
	}

	public String getTxtCol1() {
		return txtCol1;
	}

	public void setTxtCol1(String txtCol1) {
		this.txtCol1 = txtCol1;
	}

	public String getTxtCol2() {
		return txtCol2;
	}

	public void setTxtCol2(String txtCol2) {
		this.txtCol2 = txtCol2;
	}

	public String getTxtCol3() {
		return txtCol3;
	}

	public void setTxtCol3(String txtCol3) {
		this.txtCol3 = txtCol3;
	}

	public String getTxtCol4() {
		return txtCol4;
	}

	public void setTxtCol4(String txtCol4) {
		this.txtCol4 = txtCol4;
	}

	public String getTxtCol5() {
		return txtCol5;
	}

	public void setTxtCol5(String txtCol5) {
		this.txtCol5 = txtCol5;
	}

	public String getTxtCol6() {
		return txtCol6;
	}

	public void setTxtCol6(String txtCol6) {
		this.txtCol6 = txtCol6;
	}

	public String getTxtCol7() {
		return txtCol7;
	}

	public void setTxtCol7(String txtCol7) {
		this.txtCol7 = txtCol7;
	}

	public String getTxtCol8() {
		return txtCol8;
	}

	public void setTxtCol8(String txtCol8) {
		this.txtCol8 = txtCol8;
	}

	public String getTxtCol9() {
		return txtCol9;
	}

	public void setTxtCol9(String txtCol9) {
		this.txtCol9 = txtCol9;
	}

	public String getTxtCol10() {
		return txtCol10;
	}

	public void setTxtCol10(String txtCol10) {
		this.txtCol10 = txtCol10;
	}

	public String getTxtCol11() {
		return txtCol11;
	}

	public void setTxtCol11(String txtCol11) {
		this.txtCol11 = txtCol11;
	}

	public String getTxtCol12() {
		return txtCol12;
	}

	public void setTxtCol12(String txtCol12) {
		this.txtCol12 = txtCol12;
	}

	public String getTxtCol13() {
		return txtCol13;
	}

	public void setTxtCol13(String txtCol13) {
		this.txtCol13 = txtCol13;
	}

	public String getTxtCol14() {
		return txtCol14;
	}

	public void setTxtCol14(String txtCol14) {
		this.txtCol14 = txtCol14;
	}

	public String getTxtCol15() {
		return txtCol15;
	}

	public void setTxtCol15(String txtCol15) {
		this.txtCol15 = txtCol15;
	}

	public String getInReport() {
		return inReport;
	}

	public void setInReport(String inReport) {
		this.inReport = inReport;
	}

	public String getCompFinc() {
		return compFinc;
	}

	public void setCompFinc(String compFinc) {
		this.compFinc = compFinc;
	}

}
