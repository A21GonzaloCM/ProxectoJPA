package com.a21gonzalocm.festivales.Model;

import jakarta.persistence.Embeddable;

@Embeddable
public class TipoMusica {
    private String genero;
    private String subgenero;

    public TipoMusica() {
    }

    public TipoMusica(String genero, String subgenero) {
        this.genero = genero;
        this.subgenero = subgenero;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSubgenero() {
        return subgenero;
    }

    public void setSubgenero(String subgenero) {
        this.subgenero = subgenero;
    }
}