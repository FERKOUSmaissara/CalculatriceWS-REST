
package org.nanterreU.fr.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.nanterreU.fr.ws package. 
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

    private final static QName _AdditionnerResponse_QNAME = new QName("http://ws.fr.nanterreU.org/", "additionnerResponse");
    private final static QName _Multiplier_QNAME = new QName("http://ws.fr.nanterreU.org/", "multiplier");
    private final static QName _Additionner_QNAME = new QName("http://ws.fr.nanterreU.org/", "additionner");
    private final static QName _MultiplierResponse_QNAME = new QName("http://ws.fr.nanterreU.org/", "multiplierResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nanterreU.fr.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Additionner }
     * 
     */
    public Additionner createAdditionner() {
        return new Additionner();
    }

    /**
     * Create an instance of {@link MultiplierResponse }
     * 
     */
    public MultiplierResponse createMultiplierResponse() {
        return new MultiplierResponse();
    }

    /**
     * Create an instance of {@link Multiplier }
     * 
     */
    public Multiplier createMultiplier() {
        return new Multiplier();
    }

    /**
     * Create an instance of {@link AdditionnerResponse }
     * 
     */
    public AdditionnerResponse createAdditionnerResponse() {
        return new AdditionnerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdditionnerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fr.nanterreU.org/", name = "additionnerResponse")
    public JAXBElement<AdditionnerResponse> createAdditionnerResponse(AdditionnerResponse value) {
        return new JAXBElement<AdditionnerResponse>(_AdditionnerResponse_QNAME, AdditionnerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multiplier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fr.nanterreU.org/", name = "multiplier")
    public JAXBElement<Multiplier> createMultiplier(Multiplier value) {
        return new JAXBElement<Multiplier>(_Multiplier_QNAME, Multiplier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Additionner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fr.nanterreU.org/", name = "additionner")
    public JAXBElement<Additionner> createAdditionner(Additionner value) {
        return new JAXBElement<Additionner>(_Additionner_QNAME, Additionner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fr.nanterreU.org/", name = "multiplierResponse")
    public JAXBElement<MultiplierResponse> createMultiplierResponse(MultiplierResponse value) {
        return new JAXBElement<MultiplierResponse>(_MultiplierResponse_QNAME, MultiplierResponse.class, null, value);
    }

}
