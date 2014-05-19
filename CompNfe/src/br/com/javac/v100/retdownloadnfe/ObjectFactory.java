
package br.com.javac.v100.retdownloadnfe;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.javac.v100.retdownloadnfe package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RetDownloadNFe_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "retDownloadNFe");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.javac.v100.retdownloadnfe
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TRetDownloadNFe }
     * 
     */
    public TRetDownloadNFe createTRetDownloadNFe() {
        return new TRetDownloadNFe();
    }

    /**
     * Create an instance of {@link TRetDownloadNFe.RetNFe.ProcNFe }
     * 
     */
    public TRetDownloadNFe.RetNFe.ProcNFe createTRetDownloadNFeRetNFeProcNFe() {
        return new TRetDownloadNFe.RetNFe.ProcNFe();
    }

    /**
     * Create an instance of {@link TRetDownloadNFe.RetNFe }
     * 
     */
    public TRetDownloadNFe.RetNFe createTRetDownloadNFeRetNFe() {
        return new TRetDownloadNFe.RetNFe();
    }

    /**
     * Create an instance of {@link TRetDownloadNFe.RetNFe.ProcNFeGrupoZip }
     * 
     */
    public TRetDownloadNFe.RetNFe.ProcNFeGrupoZip createTRetDownloadNFeRetNFeProcNFeGrupoZip() {
        return new TRetDownloadNFe.RetNFe.ProcNFeGrupoZip();
    }

    /**
     * Create an instance of {@link TDownloadNFe }
     * 
     */
    public TDownloadNFe createTDownloadNFe() {
        return new TDownloadNFe();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRetDownloadNFe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "retDownloadNFe")
    public JAXBElement<TRetDownloadNFe> createRetDownloadNFe(TRetDownloadNFe value) {
        return new JAXBElement<TRetDownloadNFe>(_RetDownloadNFe_QNAME, TRetDownloadNFe.class, null, value);
    }

}