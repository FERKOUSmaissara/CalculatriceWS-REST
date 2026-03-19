package com.calculatrice;

import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatriceResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(CalculatriceResource.class);
    }

    @Test
    public void testAddText() {
        String response = target("/calculatrice/add/3/4")
                .request("text/plain")
                .get(String.class);
        assertEquals("7.0", response);
    }

    @Test
    public void testSubtractText() {
        String response = target("/calculatrice/subtract/10/4")
                .request("text/plain")
                .get(String.class);
        assertEquals("6.0", response);
    }

    @Test
    public void testMultiplyText() {
        String response = target("/calculatrice/multiply/3/4")
                .request("text/plain")
                .get(String.class);
        assertEquals("12.0", response);
    }

    @Test
    public void testDivideText() {
        String response = target("/calculatrice/divide/10/2")
                .request("text/plain")
                .get(String.class);
        assertEquals("5.0", response);
    }

    @Test
    public void testDivideByZeroText() {
        String response = target("/calculatrice/divide/10/0")
                .request("text/plain")
                .get(String.class);
        assertTrue(response.contains("zéro"));
    }

    @Test
    public void testAddXml() {
        String response = target("/calculatrice/add/3/4")
                .request("text/xml")
                .get(String.class);
        assertTrue(response.contains("<resultat>7.0</resultat>"));
        assertTrue(response.contains("<operation>addition</operation>"));
    }

    @Test
    public void testSubtractHtml() {
        String response = target("/calculatrice/subtract/10/4")
                .request("text/html")
                .get(String.class);
        assertTrue(response.contains("6.0"));
        assertTrue(response.contains("Soustraction"));
    }
}
