package br.com.service.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="infoNfe")
public class InfNfe {
	
	@XmlAttribute
	public String Id;
	@XmlAttribute
	public String versao; 
	//private String mlns:xsi;
	
	
	
	@Override
	public String toString() {
		return "InfNfe [Id=" + Id + ", versao=" + versao + "]";
	}



	public String getId() {
		return Id;
	}



	public void setId(String id) {
		Id = id;
	}



	public String getVersao() {
		return versao;
	}



	public void setVersao(String versao) {
		this.versao = versao;
	}

}
