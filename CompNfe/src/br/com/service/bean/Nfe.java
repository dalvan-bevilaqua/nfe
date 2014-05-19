package br.com.service.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Nfe")
public class Nfe {
	@XmlAttribute
	public String xmlns;

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	@Override
	public String toString() {
		return "Nfe [xmlns=" + xmlns + "]";
	}
	
}
