package com.calculatrice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST resource for basic arithmetic operations.
 * Supports plain text, XML, and HTML response formats.
 */
@Path("/calculatrice")
public class CalculatriceResource {

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addText(@PathParam("a") double a, @PathParam("b") double b) {
        return String.valueOf(a + b);
    }

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_XML)
    public String addXml(@PathParam("a") double a, @PathParam("b") double b) {
        return buildXml("addition", a, b, a + b);
    }

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String addHtml(@PathParam("a") double a, @PathParam("b") double b) {
        return buildHtml("Addition", a, "+", b, a + b);
    }

    @GET
    @Path("/subtract/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String subtractText(@PathParam("a") double a, @PathParam("b") double b) {
        return String.valueOf(a - b);
    }

    @GET
    @Path("/subtract/{a}/{b}")
    @Produces(MediaType.TEXT_XML)
    public String subtractXml(@PathParam("a") double a, @PathParam("b") double b) {
        return buildXml("soustraction", a, b, a - b);
    }

    @GET
    @Path("/subtract/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String subtractHtml(@PathParam("a") double a, @PathParam("b") double b) {
        return buildHtml("Soustraction", a, "-", b, a - b);
    }

    @GET
    @Path("/multiply/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String multiplyText(@PathParam("a") double a, @PathParam("b") double b) {
        return String.valueOf(a * b);
    }

    @GET
    @Path("/multiply/{a}/{b}")
    @Produces(MediaType.TEXT_XML)
    public String multiplyXml(@PathParam("a") double a, @PathParam("b") double b) {
        return buildXml("multiplication", a, b, a * b);
    }

    @GET
    @Path("/multiply/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String multiplyHtml(@PathParam("a") double a, @PathParam("b") double b) {
        return buildHtml("Multiplication", a, "*", b, a * b);
    }

    @GET
    @Path("/divide/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String divideText(@PathParam("a") double a, @PathParam("b") double b) {
        if (b == 0) {
            return "Erreur: division par zéro";
        }
        return String.valueOf(a / b);
    }

    @GET
    @Path("/divide/{a}/{b}")
    @Produces(MediaType.TEXT_XML)
    public String divideXml(@PathParam("a") double a, @PathParam("b") double b) {
        if (b == 0) {
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<erreur>Division par zéro</erreur>";
        }
        return buildXml("division", a, b, a / b);
    }

    @GET
    @Path("/divide/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String divideHtml(@PathParam("a") double a, @PathParam("b") double b) {
        if (b == 0) {
            return "<!DOCTYPE html><html><body>"
                    + "<h2>Erreur</h2><p>Division par z&eacute;ro</p>"
                    + "</body></html>";
        }
        return buildHtml("Division", a, "/", b, a / b);
    }

    private String buildXml(String operation, double a, double b, double result) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<calcul>"
                + "<operation>" + operation + "</operation>"
                + "<a>" + a + "</a>"
                + "<b>" + b + "</b>"
                + "<resultat>" + result + "</resultat>"
                + "</calcul>";
    }

    private String buildHtml(String operation, double a, String operator, double b, double result) {
        return "<!DOCTYPE html><html><head><title>Calculatrice</title></head><body>"
                + "<h2>" + operation + "</h2>"
                + "<p>" + a + " " + operator + " " + b + " = <strong>" + result + "</strong></p>"
                + "</body></html>";
    }
}
