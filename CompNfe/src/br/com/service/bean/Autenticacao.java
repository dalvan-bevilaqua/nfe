package br.com.service.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.service.common.ConfigValidention;

@XmlRootElement
public class Autenticacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute
	private String version = ConfigValidention.VERSAO.toString();
	
	private String token;
	private String status;
	private String message;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
