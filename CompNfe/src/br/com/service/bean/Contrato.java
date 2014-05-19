package br.com.service.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="tb_sys_contrato")
public class Contrato implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8154783536638946914L;
	@Id
	@Column(name="COD_CONTRATO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codContrato;
	
	/*@Column(name="COD_CONTRATO_CNPJ")
	private int codCliente;*/
	@Column(name="COD_VENDEDOR")
	private int codVendedor;
	
	@Column(name="NUM_CONTRATO")
	private String numContrato;
	@Column(name="DAT_VIGENCIA_INI")
	private Calendar dtVigIni;
	@Column(name="DAT_VIGENCIA_FIM")
	private Calendar dtVigfim;
	@Column(name="comissao")
	private BigDecimal comissao;
	@Column(name="QTD_PROCESS_MES")
	private int qtdeProcMes;
	@Column(name="QTD_PROCESS_ATU")
	private int qtdeProcAtual;
	@Column(name="DAT_ULTIMA_ATU")
	private Calendar dtUltimaAtualizacao;
	@Column(name="DAT_CRIACAO")
	private Calendar dtCriacao;
	@Column(name="QTD_CNPJ")
	private int qtdeCnpj;
	@Column(name="QTD_NF")
	private int qtdeNf;
	@Column(name="QTD_PARCELAS")
	private String qtdeParcelas;
	@Column(name="VALOR")
	private BigDecimal valor;
	@Column(name="IN_ATIVO")
	private char inAtivo;
	@Column(name="COD_CONTRATO_TIPO")
	private String codContratoType;
	@Column(name="mensalidade")
	private BigDecimal mensalidade;	
	
	@OneToMany(mappedBy = "cont", fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
    List<Cliente> clientes = new ArrayList<Cliente>();
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public int getCodContrto() {
		return codContrato;
	}
	public void setCodContrto(int codContrto) {
		this.codContrato = codContrto;
	}
/*	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}*/
	public int getCodVendedor() {
		return codVendedor;
	}
	public void setCodVendedor(int codVendedor) {
		this.codVendedor = codVendedor;
	}
	public String getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	public Calendar getDtVigIni() {
		return dtVigIni;
	}
	public void setDtVigIni(Calendar dtVigIni) {
		this.dtVigIni = dtVigIni;
	}
	public Calendar getDtVigfim() {
		return dtVigfim;
	}
	public void setDtVigfim(Calendar dtVigfim) {
		this.dtVigfim = dtVigfim;
	}
	public BigDecimal getComissao() {
		return comissao;
	}
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
	public int getQtdeProcMes() {
		return qtdeProcMes;
	}
	public void setQtdeProcMes(int qtdeProcMes) {
		this.qtdeProcMes = qtdeProcMes;
	}
	public int getQtdeProcAtual() {
		return qtdeProcAtual;
	}
	public void setQtdeProcAtual(int qtdeProcAtual) {
		this.qtdeProcAtual = qtdeProcAtual;
	}
	public Calendar getDtUltimaAtualizacao() {
		return dtUltimaAtualizacao;
	}
	public void setDtUltimaAtualizacao(Calendar dtUltimaAtualizacao) {
		this.dtUltimaAtualizacao = dtUltimaAtualizacao;
	}
	public Calendar getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(Calendar dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public int getQtdeCnpj() {
		return qtdeCnpj;
	}
	public void setQtdeCnpj(int qtdeCnpj) {
		this.qtdeCnpj = qtdeCnpj;
	}
	public int getQtdeNf() {
		return qtdeNf;
	}
	public void setQtdeNf(int qtdeNf) {
		this.qtdeNf = qtdeNf;
	}
	public String getQtdeParcelas() {
		return qtdeParcelas;
	}
	public void setQtdeParcelas(String qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public char getInAtivo() {
		return inAtivo;
	}
	public void setInAtivo(char inAtivo) {
		this.inAtivo = inAtivo;
	}
	public String getCodContratoType() {
		return codContratoType;
	}
	public void setCodContratoType(String codContratoType) {
		this.codContratoType = codContratoType;
	}
	public BigDecimal getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(BigDecimal mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	
	
	

}
