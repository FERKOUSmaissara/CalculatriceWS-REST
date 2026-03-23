package org.nanterreU.fr.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.nanterreU.fr.ws.CalculatriceServiceRemote;

/**
 * Client SOAP simple pour tester le service CalculatriceService.
 *
 * Pour l'exécuter :
 *  1. Déployer CalculatriceSOAP.war sur Tomcat
 *  2. Vérifier que le WSDL est accessible :
 *     http://localhost:8080/CalculatriceSOAP/ws/calculatrice?wsdl
 *  3. Lancer cette classe en Java (Run As > Java Application)
 */
public class CalculatriceClient {

    public static void main(String[] args) throws Exception {

        // Adresse du WSDL généré automatiquement
        URL wsdlUrl = new URL("http://localhost:8080/CalculatriceSOAP/ws/calculatrice?wsdl");

        // Le QName doit correspondre au serviceName de @WebService
        QName serviceName = new QName("http://ws.fr.nanterreU.org/", "CalculatriceService");

        Service service = Service.create(wsdlUrl, serviceName);
        CalculatriceServiceRemote calc = service.getPort(CalculatriceServiceRemote.class);

        System.out.println("=== Test du service SOAP Calculatrice ===");
        System.out.println("10 + 5   = " + calc.additionner(10, 5));
        System.out.println("10 * 5   = " + calc.multiplier(10, 5));
        System.out.println("10 - 5   = " + calc.soustraire(10, 5));
        System.out.println("10 / 5   = " + calc.diviser(10, 5));
        System.out.println("7.5 + 2.5 = " + calc.additionner(7.5, 2.5));
    }
}
