package org.nanterreU.fr.ws;

import javax.jws.WebService;

/**
 * Implémentation du service SOAP Calculatrice.
 *
 * @WebService(endpointInterface) dit à JAX-WS d'utiliser l'interface ICalculatrice
 * pour générer le WSDL automatiquement.
 *
 * Pas besoin de @Stateless, on est sur Tomcat (pas WildFly).
 */
@WebService(
    serviceName       = "CalculatriceService",
    portName          = "CalculatricePort",
    endpointInterface = "org.nanterreU.fr.ws.ICalculatrice",
    targetNamespace   = "http://ws.fr.nanterreU.org/"
)
public class CalculatriceImpl implements ICalculatrice {

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
