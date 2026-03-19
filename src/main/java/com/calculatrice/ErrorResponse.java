package com.calculatrice;

/**
 * Simple JSON error response wrapper.
 */
public class ErrorResponse {

    private String erreur;

    public ErrorResponse() {
    }

    public ErrorResponse(String erreur) {
        this.erreur = erreur;
    }

    public String getErreur() {
        return erreur;
    }

    public void setErreur(String erreur) {
        this.erreur = erreur;
    }
}
