package br.com.service.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="nfeProc",namespace="http://www.portalfiscal.inf.br/nfe")  
@XmlType(propOrder = { "nFe", "infNfe" })  
@XmlAccessorType(XmlAccessType.FIELD)  
public class NFiscalEletronica {
	
@XmlElement(name="NFe")  
public Nfe nFe;  

@XmlElement(name="protNFe")  
public InfNfe infNfe;  

@XmlAttribute  
public String versao;  
  
/*@XmlAttribute  
public String xmlns;  */

public Nfe getnFe() {  
    return nFe;  
}  

public void setnFe(Nfe nFe) {  
    this.nFe = nFe;  
}  

public InfNfe getInfNfe() {  
    return infNfe;  
}  

public void setInfNfe(InfNfe infNfe) {  
    this.infNfe = infNfe;  
}  

public String getVersao() {  
    return versao;  
}  

public void setVersao(String versao) {  
    this.versao = versao;  
}

@Override
public String toString() {
	return "NFiscalEletronica [nFe=" + nFe + ", infNfe=" + infNfe + ", versao=" + versao + "]";
}  

/*public String getXmlns() {  
    return xmlns;  
}  

public void setXmlns(String xmlns) {  
    this.xmlns = xmlns;  
}*/

 

}  