package org.nanterreU.fr.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Interface du service SOAP (SEI = Service Endpoint Interface).
 * Déclare les opérations disponibles.
 */
@WebService(name = "ICalculatrice", targetNamespace = "http://ws.fr.nanterreU.org/")
public interface ICalculatrice {

    @WebMethod
    double additionner(@WebParam(name = "a") double a,
                       @WebParam(name = "b") double b);

    @WebMethod
    double multiplier(@WebParam(name = "a") double a,
                      @WebParam(name = "b") double b);

    @WebMethod
    double soustraire(@WebParam(name = "a") double a,
                      @WebParam(name = "b") double b);

    @WebMethod
    double diviser(@WebParam(name = "a") double a,
                   @WebParam(name = "b") double b);
}
