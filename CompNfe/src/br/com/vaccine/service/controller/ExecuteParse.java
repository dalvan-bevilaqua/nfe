package br.com.vaccine.service.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.javac.bean.Usuario;
import br.com.javac.v200.envinfe.TNfeProc;
import br.com.service.bean.CriticaTO;
import br.com.service.bean.Ide;
import br.com.service.bean.Logger;
import br.com.service.bean.SugestaoTO;
import br.com.service.retorno.NtkErro;
import br.com.service.retorno.NtkErro.Erro;

public class ExecuteParse implements ParseXml {
	
	private Process processo = new CreateProcess();
	private Config config = new InitProcess();

	
	public TNfeProc getTNfeProc(String xml) throws Exception {
		try {

			JAXBContext context = JAXBContext.newInstance(TNfeProc.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			TNfeProc nfe = unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), TNfeProc.class).getValue();
			return nfe;

		} catch (JAXBException ex) {
			throw new Exception(ex.toString());
		}
	}
	
	
	public static Usuario getTNfeProcUsr(String xml) throws Exception {
		try {

			JAXBContext context = JAXBContext.newInstance(Usuario.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Usuario nfe = unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), Usuario.class).getValue();
			return nfe;

		} catch (JAXBException ex) {
			throw new Exception(ex.toString());
		}
	}

	public String getErro(String msgErro) {
		NtkErro ntkErro = new NtkErro();
		Erro erro = new Erro();
		erro.setMsg(msgErro);

		JAXBContext context;
		StringWriter sw = null;
		ntkErro.setErro(erro);

		try {
			context = JAXBContext.newInstance(ntkErro.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, new String("UTF-8"));
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// marshaller.marshal(tp, new
			// FileWriter("C:\\vaccinewsdl\\xml\\nfe"));
			sw = new StringWriter();
			marshaller.marshal(ntkErro, sw);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sw.toString());
		return  sw.toString();

	}

	public void validator(String xsdFile, Object object) {
		try {

			JAXBContext jc = JAXBContext.newInstance(object.getClass());
			JAXBSource source = new JAXBSource(jc, object);

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File(xsdFile));

			javax.xml.validation.Validator validator = schema.newValidator();
			validator.setErrorHandler(new ValidatorErrorHandler());
			validator.validate(source);

			System.out.println("Successful validation!");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public String lerXML(String fileXML) throws IOException {
		String linha = "";
		StringBuilder xml = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileXML)));

		while ((linha = in.readLine()) != null) {
			xml.append(linha);
		}
		in.close();
		return xml.toString();
	}

	public String getChaveNfe(String xml) throws IOException, SAXException, ParserConfigurationException {
		String chaveNFe = null, nItem = null;
		try {
			Document document = documentFactory(xml);
			NodeList nodeListNfe = document.getDocumentElement().getElementsByTagName("NFe");
			NodeList nodeListInfNfe = document.getElementsByTagName("infNFe");
			NodeList nodeListIde = document.getElementsByTagName("det");

			for (int i = 0; i < nodeListNfe.getLength(); i++) {
				Element el = (Element) nodeListInfNfe.item(i);
				chaveNFe = el.getAttribute("Id");
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return chaveNFe;
	}

	private static Document documentFactory(String xml) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		Document document = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
		return document;
	}

	public String marshal(Object object) {
		final StringWriter out = new StringWriter();
		JAXBContext context = null;
		Marshaller marshaller = null;
		try {
			context = JAXBContext.newInstance(object.getClass());
			marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(object, new StreamResult(out));

		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return out.toString();
	}
	
	@Override
	public String criaXmlRetorno(int codigo,String mensagem) {
		StringWriter stringWriter = null;		
		try{
		Document doc = criaXml();
		Element retorno=montaCabecarioErro(doc,codigo,mensagem);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);

		stringWriter = new StringWriter();
		StreamResult result = new StreamResult(stringWriter);			
		transformer.transform(source, result);
		
		}catch(Exception e){
			Logger.log("ERRO", e.getMessage());
			e.printStackTrace();
			//throw new Exception("erro na montagem do xml  "+getClass()+" "+e.getMessage());
		}
		
		return stringWriter.toString();
	}
	
	@Override
	public String criaXmlRetCri(Ide ide,List<CriticaTO> criticas) throws Exception {
		
		StringWriter stringWriter = null;				
		Document doc = criaXml();		
		Element retorno=montaCabecarioProcesso(doc, ide);
		

		try {
			
			Element protocolo = doc.createElement("protocolo");
			protocolo.appendChild(doc.createTextNode(String.valueOf(ide.getIdIDe())));
			retorno.appendChild(protocolo);			
			
			
			if (config.validTypeOper(ide,criticas.size())) {
				processo.totalLista(doc, retorno, criticas.size(), "qtdeCriticas");
				Element qtdeSugestao = doc.createElement("qtdeSugestoes");	
				qtdeSugestao.appendChild(doc.createTextNode("0"));
				retorno.appendChild(qtdeSugestao);
				
				Element ocorrencias = doc.createElement("ocorrencias");					
				
				int cont=0;
				for (CriticaTO c : criticas) {
					cont = montaTagXmlRetorno(doc, ocorrencias, cont, c);
				}
				retorno.appendChild(ocorrencias);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			stringWriter = new StringWriter();
			StreamResult result = new StreamResult(stringWriter);			
			transformer.transform(source, result);

		} catch (Exception e) {
			Logger.log("ERRO", e.getMessage());
			e.printStackTrace();
			throw new Exception("Erro xml de retorno formula "+e.getMessage());

		}
		return stringWriter.toString();

	}
	
	@Override
	public String criaXmlRetSaidaSemCritica(Ide ide) throws Exception {
		
		StringWriter stringWriter = null;				
		Document doc = criaXml();		
		Element retorno=montaCabecarioProcesso(doc, ide);
		

		try {
			
			Element protocolo = doc.createElement("protocolo");
			protocolo.appendChild(doc.createTextNode(String.valueOf(ide.getIdIDe())));
			retorno.appendChild(protocolo);			
		
			Element qtdeCriticas = doc.createElement("qtdeCriticas");	
			qtdeCriticas.appendChild(doc.createTextNode("0"));
			retorno.appendChild(qtdeCriticas);
			
			Element qtdeSugestao = doc.createElement("qtdeSugestoes");	
			qtdeSugestao.appendChild(doc.createTextNode("0"));
			retorno.appendChild(qtdeSugestao);
			
			Element msg = doc.createElement("mensagem");	
			msg.appendChild(doc.createTextNode("NF-e sem erros"));
			retorno.appendChild(msg);
					
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			stringWriter = new StringWriter();
			StreamResult result = new StreamResult(stringWriter);			
			transformer.transform(source, result);

		} catch (Exception e) {
			Logger.log("ERRO", e.getMessage());
			e.printStackTrace();
			throw new Exception("Erro xml de retorno formula "+e.getMessage());

		}
		return stringWriter.toString();

	}
	
	@Override
	public Document criaXml() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=null;
		try {
		 docBuilder = docFactory.newDocumentBuilder();
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		return docBuilder.newDocument();
	}
	
	@Override
	public Element montaCabecarioProcesso(Document doc,Ide ide) {
		Element rootElement = doc.createElement("retorno");
		doc.appendChild(rootElement);		
		
		Element status = doc.createElement("status");
		status.appendChild(doc.createTextNode("0"));
		rootElement.appendChild(status);

		Element retorno = doc.createElement("vaccineNFe");
		Attr attr = doc.createAttribute("chNFe");
		attr.setValue(ide.getChNFe());
		retorno.setAttributeNode(attr);
		
		Attr attr2 = doc.createAttribute("numNFe");
		attr2.setValue(String.valueOf(ide.getNnf()));
		retorno.setAttributeNode(attr2);			
		rootElement.appendChild(retorno);
		
		return retorno;
	}
	
	@Override
	public Element montaCabecarioErro(Document doc,int codStatus,String msgStatus) {
		Element rootElement = doc.createElement("retorno");
		doc.appendChild(rootElement);		
		
		Element status = doc.createElement("status");
		status.appendChild(doc.createTextNode(String.valueOf(codStatus)));
		rootElement.appendChild(status);
		
		Element msg = doc.createElement("mensagem");
		msg.appendChild(doc.createTextNode(msgStatus));
		rootElement.appendChild(msg);
		
		return rootElement;
	}


	
	@Override
	public int montaTagXmlRetorno(Document doc, Element retorno, int cont, CriticaTO critica) throws Exception {
		
		try{			
			
		cont++;		
		
		Element ocorrencia = doc.createElement("ocorrencia");									
		retorno.appendChild(ocorrencia);
		
		Attr attr3 = doc.createAttribute("id");
		attr3.setValue(String.valueOf(cont));
		ocorrencia.setAttributeNode(attr3);
							
		Element formula = doc.createElement("nomForm");
		formula.appendChild(doc.createTextNode(critica.getNomFormula()));				
		ocorrencia.appendChild(formula);					
		
		if (critica.getTxtCri1() != null) {
			Element for1 = doc.createElement(critica.getTxtFor1());
			for1.appendChild(doc.createTextNode(critica.getTxtCri1()));
			ocorrencia.appendChild(for1);
		}

		if (critica.getTxtCri2() != null) {
			Element for2 = doc.createElement(critica.getTxtFor2());
			for2.appendChild(doc.createTextNode(critica.getTxtCri2()));
			ocorrencia.appendChild(for2);
		}
		if (critica.getTxtCri3() != null) {
			Element for3 = doc.createElement(critica.getTxtFor3());
			for3.appendChild(doc.createTextNode(critica.getTxtCri3()));
			ocorrencia.appendChild(for3);
		}

		if (critica.getTxtCri4() != null) {
			Element for4 = doc.createElement(critica.getTxtFor4());
			for4.appendChild(doc.createTextNode(critica.getTxtCri4()));
			ocorrencia.appendChild(for4);
		}

		if (critica.getTxtCri5() != null) {
			Element for5 = doc.createElement(critica.getTxtFor5());
			for5.appendChild(doc.createTextNode(critica.getTxtCri5()));
			ocorrencia.appendChild(for5);
		}
		if (critica.getTxtCri6() != null) {
			Element for6 = doc.createElement(critica.getTxtFor6());
			for6.appendChild(doc.createTextNode(critica.getTxtCri6()));
			ocorrencia.appendChild(for6);
		}
		if (critica.getTxtCri7() != null) {
			Element for7 = doc.createElement(critica.getTxtFor7());
			for7.appendChild(doc.createTextNode(critica.getTxtCri7()));
			ocorrencia.appendChild(for7);
		}
		if (critica.getTxtCri8() != null) {
			Element for8 = doc.createElement(critica.getTxtFor8());
			for8.appendChild(doc.createTextNode(critica.getTxtCri8()));
			ocorrencia.appendChild(for8);
		}
		if (critica.getTxtCri9() != null) {
			Element for9 = doc.createElement(critica.getTxtFor9());
			for9.appendChild(doc.createTextNode(critica.getTxtCri9()));
			ocorrencia.appendChild(for9);
		}
		if (critica.getTxtCri10() != null) {
			Element for10 = doc.createElement(critica.getTxtFor10());
			for10.appendChild(doc.createTextNode(critica.getTxtCri10()));
			ocorrencia.appendChild(for10);
		}
			}catch(Exception e){
				throw e;
			}
		return cont;
	}
	
	@Override
	public int montaTagXmlRetorno(Document doc, Element retorno, int cont, SugestaoTO sugestao) throws Exception{
		try{
		cont++;
		
		
		Element ocorrencia = doc.createElement("ocorrencia");									
		retorno.appendChild(ocorrencia);
		
		Attr attr3 = doc.createAttribute("id");
		attr3.setValue(String.valueOf(cont));
		ocorrencia.setAttributeNode(attr3);
							
		Element formula = doc.createElement("nomForm");
		formula.appendChild(doc.createTextNode(sugestao.getNomFormula()));				
		ocorrencia.appendChild(formula);					
		
		if (sugestao.getTxtCri1() != null) {
			Element for1 = doc.createElement(sugestao.getTxtFor1());
			for1.appendChild(doc.createTextNode(sugestao.getTxtCri1()));
			ocorrencia.appendChild(for1);
		}

		if (sugestao.getTxtCri2() != null) {
			Element for2 = doc.createElement(sugestao.getTxtFor2());
			for2.appendChild(doc.createTextNode(sugestao.getTxtCri2()));
			ocorrencia.appendChild(for2);
		}

		if (sugestao.getTxtCri3() != null) {
			Element for3 = doc.createElement(sugestao.getTxtFor3());
			for3.appendChild(doc.createTextNode(sugestao.getTxtCri3()));
			ocorrencia.appendChild(for3);
		}

		if (sugestao.getTxtCri4() != null) {
			Element for4 = doc.createElement(sugestao.getTxtFor4());
			for4.appendChild(doc.createTextNode(sugestao.getTxtCri4()));
			ocorrencia.appendChild(for4);
		}

		if (sugestao.getTxtCri5() != null) {
			try{
			Element for5 = doc.createElement(sugestao.getTxtFor5());				
			for5.appendChild(doc.createTextNode(sugestao.getTxtCri5()));
			ocorrencia.appendChild(for5);
			}catch(Exception e){
				
				e.printStackTrace();
			}
		}
		if (sugestao.getTxtCri6() != null) {
			Element for6 = doc.createElement(sugestao.getTxtFor6());
			for6.appendChild(doc.createTextNode(sugestao.getTxtCri6()));
			ocorrencia.appendChild(for6);
		}
		if (sugestao.getTxtCri7() != null) {
			Element for7 = doc.createElement(sugestao.getTxtFor7());
			for7.appendChild(doc.createTextNode(sugestao.getTxtCri7()));
			ocorrencia.appendChild(for7);
		}
		if (sugestao.getTxtCri8() != null) {
			Element for8 = doc.createElement(sugestao.getTxtFor8());
			for8.appendChild(doc.createTextNode(sugestao.getTxtCri8()));
			ocorrencia.appendChild(for8);
		}
		if (sugestao.getTxtCri9() != null) {
			Element for9 = doc.createElement(sugestao.getTxtFor9());
			for9.appendChild(doc.createTextNode(sugestao.getTxtCri9()));
			ocorrencia.appendChild(for9);
		}
		if (sugestao.getTxtCri10() != null) {
			Element for10 = doc.createElement(sugestao.getTxtFor10());
			for10.appendChild(doc.createTextNode(sugestao.getTxtCri10()));
			ocorrencia.appendChild(for10);
		}
		}catch(Exception e){
			throw e;
		}
		return cont;
	}

	@Override
	public String criaXmlRetSug(Ide ide, List<SugestaoTO> sugestoes ,int totalCri) throws Exception {
		
		StringWriter stringWriter = null;				
		Document doc = criaXml();		
		Element retorno=montaCabecarioProcesso(doc, ide);
		

		try {
			
			int totalSug=sugestoes.size();
			
			Element mensagem = doc.createElement("mensagem");
			mensagem.appendChild(doc.createTextNode("Nf-e sem erros"));
			retorno.appendChild(mensagem);	
			
			Element protocolo = doc.createElement("protocolo");
			protocolo.appendChild(doc.createTextNode(String.valueOf(ide.getIdIDe())));
			retorno.appendChild(protocolo);		
			
			Element critica = doc.createElement("qtdeCriticas");
			critica.appendChild(doc.createTextNode(String.valueOf(0)));
			retorno.appendChild(critica);	
			
			if (!config.validTypeOper(ide,totalCri)) {
				processo.totalLista(doc, retorno, totalSug, "qtdeSugestoes");
			Element ocorrencias = doc.createElement("ocorrencias");							
				
				int cont=0;
				for (SugestaoTO s : sugestoes) {
					cont = montaTagXmlRetorno(doc, ocorrencias, cont, s);
				}
				retorno.appendChild(ocorrencias);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			stringWriter = new StringWriter();
			StreamResult result = new StreamResult(stringWriter);			
			transformer.transform(source, result);

		} catch (Exception e) {
			Logger.log("ERRO"+getClass()+" ", e.getMessage());
			e.printStackTrace();
			throw new Exception("ERRO"+getClass()+" "+e.getMessage());

		}
		return stringWriter.toString();

	}

	

}
