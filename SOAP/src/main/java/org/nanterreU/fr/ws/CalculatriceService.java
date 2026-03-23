package org.nanterreU.fr.ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Implémentation du service SOAP Calculatrice.
 *
 * @Stateless  -> EJB sans état (Tomcat ignore cette annotation à l'exécution,
 *               mais elle est requise pour respecter le modèle EJB JAX-WS)
 * @WebService -> expose cette classe comme service SOAP, le WSDL est généré automatiquement
 */
@Stateless
@WebService(
    serviceName       = "CalculatriceService",
    portName          = "CalculatricePort",
    endpointInterface = "org.nanterreU.fr.ws.CalculatriceServiceRemote",
    targetNamespace   = "http://ws.fr.nanterreU.org/"
)
public class CalculatriceService implements CalculatriceServiceRemote {

    @Override
    public double additionner(double a, double b) {
        return a + b;
    }

    @Override
    public double multiplier(double a, double b) {
        return a * b;
    }

    @Override
    public double soustraire(double a, double b) {
        return a - b;
    }

    @Override
    public double diviser(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }
}
