package br.com.service.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/*
 * principais anota��es do JAXB:

@XmlRootElement � essa anota��o indica que o valor da classe ser� representado como um elemento XML principal;
@XmlAccessorType � indica que as anota��es est�o ou nos atributos ou nos m�todos da classe;
@XmlType � indica que essa classe na verdade mapeia um tipo de informa��o espec�fica;
@XmlElement � usada nos atributos ou m�todos. Indica que o atributo ser� uma tag do xml;
@XmlElementWrapper � mapeia um objeto do tipo lista;
@XmlAttribute � mapeia o valor de um campo como atributo no xml.

*/

 
@XmlRootElement (name="ntk vaccine") 
@XmlAccessorType(XmlAccessType.FIELD)
public class Erro {	

	@XmlAttribute(name ="versao") 	
	private String Versao;
	@XmlAttribute(name ="versaoDados") 
	private String VersaoDados;
	
	@XmlElement(name="erro")
	private String erro;
	
	
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
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
