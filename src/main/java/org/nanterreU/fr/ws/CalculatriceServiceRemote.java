package org.nanterreU.fr.ws;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Remote interface (SEI - Service Endpoint Interface) for the Calculatrice Web Service.
 * This interface is provided by the professor.
 */
@Remote
@WebService(name = "CalculatriceServiceRemote",
            targetNamespace = "http://ws.fr.nanterreU.org/")
public interface CalculatriceServiceRemote {

    @WebMethod
    double additionner(
            @WebParam(name = "operande1") double operande1,
            @WebParam(name = "operande2") double operande2);

    @WebMethod
    double multiplier(
            @WebParam(name = "operande1") double operande1,
            @WebParam(name = "operande2") double operande2);
}
