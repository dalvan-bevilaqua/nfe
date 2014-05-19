package br.com.service.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_sys_login")
public class Login implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1841730212620410219L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_LOGIN")
	private int codLogin;
	
	@Column(name="COD_CARGO")
	private int codCargo;
	
	@Column(name="COD_CLIENTE")
	private int codCliente;
	
	@Column(name="COD_PERFIL")
	private int codPerfil;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="E_MAIL")
	private String eMail;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="QTD_INVALIDO")
	private int qtdeInvalido;
	
	@Column(name="DAT_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dtCriacao;
	
	@Column(name="IN_ATIVO")
	private String inAtivo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DAT_ACESSO")
	private Calendar dtAcesso;
	
	@Column(name="COD_CONTRATO")
	private int codContrato;
	
	@Column(name="ACESSOPRIMARIO")
	private int acessoPrimario;

	public int getCodLogin() {
		return codLogin;
	}

	public void setCodLogin(int codLogin) {
		this.codLogin = codLogin;
	}

	public int getCodCargo() {
		return codCargo;
	}

	public void setCodCargo(int codCargo) {
		this.codCargo = codCargo;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(int codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getQtdeInvalido() {
		return qtdeInvalido;
	}

	public void setQtdeInvalido(int qtdeInvalido) {
		this.qtdeInvalido = qtdeInvalido;
	}

	public Calendar getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Calendar dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getInAtivo() {
		return inAtivo;
	}

	public void setInAtivo(String inAtivo) {
		this.inAtivo = inAtivo;
	}

	public Calendar getDtAcesso() {
		return dtAcesso;
	}

	public void setDtAcesso(Calendar dtAcesso) {
		this.dtAcesso = dtAcesso;
	}

	public int getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}

	public int getAcessoPrimario() {
		return acessoPrimario;
	}

	public void setAcessoPrimario(int acessoPrimario) {
		this.acessoPrimario = acessoPrimario;
	}
	

}
