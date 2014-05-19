
package br.com.javac.v101.consnfedest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.javac.v101.consnfedest package. 
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

    private final static QName _ConsNFeDest_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "consNFeDest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.javac.v101.consnfedest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TConsNFeDest }
     * 
     */
    public TConsNFeDest createTConsNFeDest() {
        return new TConsNFeDest();
    }

    /**
     * Create an instance of {@link TRetConsNFeDest.Ret.ResNFe }
     * 
     */
    public TRetConsNFeDest.Ret.ResNFe createTRetConsNFeDestRetResNFe() {
        return new TRetConsNFeDest.Ret.ResNFe();
    }

    /**
     * Create an instance of {@link TRetConsNFeDest.Ret }
     * 
     */
    public TRetConsNFeDest.Ret createTRetConsNFeDestRet() {
        return new TRetConsNFeDest.Ret();
    }

    /**
     * Create an instance of {@link TRetConsNFeDest.Ret.ResCCe }
     * 
     */
    public TRetConsNFeDest.Ret.ResCCe createTRetConsNFeDestRetResCCe() {
        return new TRetConsNFeDest.Ret.ResCCe();
    }

    /**
     * Create an instance of {@link TRetConsNFeDest.Ret.ResCanc }
     * 
     */
    public TRetConsNFeDest.Ret.ResCanc createTRetConsNFeDestRetResCanc() {
        return new TRetConsNFeDest.Ret.ResCanc();
    }

    /**
     * Create an instance of {@link TRetConsNFeDest }
     * 
     */
    public TRetConsNFeDest createTRetConsNFeDest() {
        return new TRetConsNFeDest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TConsNFeDest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "consNFeDest")
    public JAXBElement<TConsNFeDest> createConsNFeDest(TConsNFeDest value) {
        return new JAXBElement<TConsNFeDest>(_ConsNFeDest_QNAME, TConsNFeDest.class, null, value);
    }

}
