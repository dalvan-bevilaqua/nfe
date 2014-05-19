
package br.com.javac.v100.retdownloadnfe;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.w3c.dom.Element;


/**
 * Tipo Retorno do pedido de Download de NF-e
 * 
 * <p>Java class for TRetDownloadNFe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TRetDownloadNFe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *         &lt;element name="dhResp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="retNFe" maxOccurs="10" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                   &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *                   &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *                   &lt;choice minOccurs="0">
 *                     &lt;element name="procNFeGrupoZip">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="NFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *                               &lt;element name="protNFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="procNFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *                     &lt;element name="procNFe">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;any/>
 *                             &lt;/sequence>
 *                             &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerDownloadNFe" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetDownloadNFe", propOrder = {
    "tpAmb",
    "verAplic",
    "cStat",
    "xMotivo",
    "dhResp",
    "retNFe"
})
public class TRetDownloadNFe {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dhResp;
    protected List<TRetDownloadNFe.RetNFe> retNFe;
    @XmlAttribute(required = true)
    protected String versao;

    /**
     * Gets the value of the tpAmb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Sets the value of the tpAmb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    /**
     * Gets the value of the verAplic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Sets the value of the verAplic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    /**
     * Gets the value of the cStat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Sets the value of the cStat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCStat(String value) {
        this.cStat = value;
    }

    /**
     * Gets the value of the xMotivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Sets the value of the xMotivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    /**
     * Gets the value of the dhResp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDhResp() {
        return dhResp;
    }

    /**
     * Sets the value of the dhResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDhResp(XMLGregorianCalendar value) {
        this.dhResp = value;
    }

    /**
     * Gets the value of the retNFe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retNFe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetNFe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRetDownloadNFe.RetNFe }
     * 
     * 
     */
    public List<TRetDownloadNFe.RetNFe> getRetNFe() {
        if (retNFe == null) {
            retNFe = new ArrayList<TRetDownloadNFe.RetNFe>();
        }
        return this.retNFe;
    }

    /**
     * Gets the value of the versao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Sets the value of the versao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
     *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
     *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
     *         &lt;choice minOccurs="0">
     *           &lt;element name="procNFeGrupoZip">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="NFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
     *                     &lt;element name="protNFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="procNFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
     *           &lt;element name="procNFe">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;any/>
     *                   &lt;/sequence>
     *                   &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "chNFe",
        "cStat",
        "xMotivo",
        "procNFeGrupoZip",
        "procNFeZip",
        "procNFe"
    })
    public static class RetNFe {

        @XmlElement(required = true)
        protected String chNFe;
        @XmlElement(required = true)
        protected String cStat;
        @XmlElement(required = true)
        protected String xMotivo;
        protected TRetDownloadNFe.RetNFe.ProcNFeGrupoZip procNFeGrupoZip;
        protected byte[] procNFeZip;
        protected TRetDownloadNFe.RetNFe.ProcNFe procNFe;

        /**
         * Gets the value of the chNFe property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChNFe() {
            return chNFe;
        }

        /**
         * Sets the value of the chNFe property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChNFe(String value) {
            this.chNFe = value;
        }

        /**
         * Gets the value of the cStat property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCStat() {
            return cStat;
        }

        /**
         * Sets the value of the cStat property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCStat(String value) {
            this.cStat = value;
        }

        /**
         * Gets the value of the xMotivo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXMotivo() {
            return xMotivo;
        }

        /**
         * Sets the value of the xMotivo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXMotivo(String value) {
            this.xMotivo = value;
        }

        /**
         * Gets the value of the procNFeGrupoZip property.
         * 
         * @return
         *     possible object is
         *     {@link TRetDownloadNFe.RetNFe.ProcNFeGrupoZip }
         *     
         */
        public TRetDownloadNFe.RetNFe.ProcNFeGrupoZip getProcNFeGrupoZip() {
            return procNFeGrupoZip;
        }

        /**
         * Sets the value of the procNFeGrupoZip property.
         * 
         * @param value
         *     allowed object is
         *     {@link TRetDownloadNFe.RetNFe.ProcNFeGrupoZip }
         *     
         */
        public void setProcNFeGrupoZip(TRetDownloadNFe.RetNFe.ProcNFeGrupoZip value) {
            this.procNFeGrupoZip = value;
        }

        /**
         * Gets the value of the procNFeZip property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getProcNFeZip() {
            return procNFeZip;
        }

        /**
         * Sets the value of the procNFeZip property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setProcNFeZip(byte[] value) {
            this.procNFeZip = ((byte[]) value);
        }

        /**
         * Gets the value of the procNFe property.
         * 
         * @return
         *     possible object is
         *     {@link TRetDownloadNFe.RetNFe.ProcNFe }
         *     
         */
        public TRetDownloadNFe.RetNFe.ProcNFe getProcNFe() {
            return procNFe;
        }

        /**
         * Sets the value of the procNFe property.
         * 
         * @param value
         *     allowed object is
         *     {@link TRetDownloadNFe.RetNFe.ProcNFe }
         *     
         */
        public void setProcNFe(TRetDownloadNFe.RetNFe.ProcNFe value) {
            this.procNFe = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;any/>
         *       &lt;/sequence>
         *       &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "any"
        })
        public static class ProcNFe {

            @XmlAnyElement
            protected Element any;
            @XmlAttribute(required = true)
            protected String schema;

            /**
             * Gets the value of the any property.
             * 
             * @return
             *     possible object is
             *     {@link Element }
             *     
             */
            public Element getAny() {
                return any;
            }

            /**
             * Sets the value of the any property.
             * 
             * @param value
             *     allowed object is
             *     {@link Element }
             *     
             */
            public void setAny(Element value) {
                this.any = value;
            }

            /**
             * Gets the value of the schema property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSchema() {
                return schema;
            }

            /**
             * Sets the value of the schema property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSchema(String value) {
                this.schema = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="NFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
         *         &lt;element name="protNFeZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nFeZip",
            "protNFeZip"
        })
        public static class ProcNFeGrupoZip {

            @XmlElement(name = "NFeZip", required = true)
            protected byte[] nFeZip;
            @XmlElement(required = true)
            protected byte[] protNFeZip;

            /**
             * Gets the value of the nFeZip property.
             * 
             * @return
             *     possible object is
             *     byte[]
             */
            public byte[] getNFeZip() {
                return nFeZip;
            }

            /**
             * Sets the value of the nFeZip property.
             * 
             * @param value
             *     allowed object is
             *     byte[]
             */
            public void setNFeZip(byte[] value) {
                this.nFeZip = ((byte[]) value);
            }

            /**
             * Gets the value of the protNFeZip property.
             * 
             * @return
             *     possible object is
             *     byte[]
             */
            public byte[] getProtNFeZip() {
                return protNFeZip;
            }

            /**
             * Sets the value of the protNFeZip property.
             * 
             * @param value
             *     allowed object is
             *     byte[]
             */
            public void setProtNFeZip(byte[] value) {
                this.protNFeZip = ((byte[]) value);
            }

        }

    }

}
