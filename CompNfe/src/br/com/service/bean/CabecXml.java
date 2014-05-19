package br.com.service.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement // assim sai o nome da classe 
@XmlRootElement (name="ntk vaccine") //ssim eu renomeio qui é o nó
public class CabecXml {	

	@XmlAttribute(name ="versao") 	
	private String Versao;
	@XmlAttribute(name ="versaoDados") 
	private String VersaoDados;
	
	
	public String getVersao() {
		return Versao;
	}
	public void setVersao(String versao) {
		Versao = versao;
	}
	public String getVersaoDados() {
		return VersaoDados;
	}
	public void setVersaoDados(String versaoDados) {
		VersaoDados = versaoDados;
	}
	
	
}
