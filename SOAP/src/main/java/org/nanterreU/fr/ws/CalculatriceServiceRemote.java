package org.nanterreU.fr.ws;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Interface SEI (Service Endpoint Interface) du service SOAP Calculatrice.
 * @Remote  -> interface EJB accessible à distance
 * @WebService -> déclare les opérations SOAP
 */
@Remote
@WebService(name = "CalculatriceServiceRemote", targetNamespace = "http://ws.fr.nanterreU.org/")
public interface CalculatriceServiceRemote {

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
