package org.nanterreU.fr.ws;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Stateless EJB implementation of the Calculatrice Web Service.
 * This implementation is provided by the professor.
 *
 * @Stateless  -> marks this as a Stateless EJB (managed by the EJB container)
 * @WebService -> exposes this EJB as a SOAP Web Service (managed by WildFly JAX-WS)
 */
@Stateless
@WebService(
        serviceName     = "CalculatriceService",
        portName        = "CalculatriceServicePort",
        endpointInterface = "org.nanterreU.fr.ws.CalculatriceServiceRemote",
        targetNamespace = "http://ws.fr.nanterreU.org/"
)
public class CalculatriceService implements CalculatriceServiceRemote {

    @WebMethod
    @Override
    public double additionner(double a, double b) {
        return a + b;
    }

    @WebMethod
    @Override
    public double multiplier(double a, double b) {
        return a * b;
    }
}
