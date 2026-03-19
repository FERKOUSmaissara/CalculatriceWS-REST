
package org.nanterreU.fr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour additionner complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="additionner">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operande1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="operande2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "additionner", propOrder = {
    "operande1",
    "operande2"
})
public class Additionner {

    protected double operande1;
    protected double operande2;

    /**
     * Obtient la valeur de la propriété operande1.
     * 
     */
    public double getOperande1() {
        return operande1;
    }

    /**
     * Définit la valeur de la propriété operande1.
     * 
     */
    public void setOperande1(double value) {
        this.operande1 = value;
    }

    /**
     * Obtient la valeur de la propriété operande2.
     * 
     */
    public double getOperande2() {
        return operande2;
    }

    /**
     * Définit la valeur de la propriété operande2.
     * 
     */
    public void setOperande2(double value) {
        this.operande2 = value;
    }

}
