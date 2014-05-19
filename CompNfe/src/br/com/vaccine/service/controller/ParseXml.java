package br.com.vaccine.service.controller;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import br.com.javac.v200.envinfe.TNfeProc;
import br.com.service.bean.CriticaTO;
import br.com.service.bean.Ide;
import br.com.service.bean.SugestaoTO;

public interface ParseXml {
	
	
	String criaXmlRetCri(Ide nf,List<CriticaTO> criticas) throws Exception;
	public String criaXmlRetSaidaSemCritica(Ide ide) throws Exception;
	String criaXmlRetSug(Ide nf,List<SugestaoTO> sugestoes,int totalCri) throws Exception;

	String criaXmlRetorno(int codigo,String msgErro) throws Exception;
	
	
	TNfeProc getTNfeProc(String xml) throws Exception;
	String getErro(String msgErro);
	String lerXML(String fileXML) throws IOException;
	String getChaveNfe(String xml) throws IOException, SAXException, ParserConfigurationException;
	
	

     int montaTagXmlRetorno(Document doc, Element retorno, int cont, CriticaTO critica) throws Exception;
     int montaTagXmlRetorno(Document doc, Element retorno, int cont, SugestaoTO sugestao)throws Exception;

     Document criaXml();
     Element montaCabecarioProcesso(Document doc,Ide ide);
     Element montaCabecarioErro(Document doc,int codStatus,String msgStatus);
	
	
	
	
	
	
}
