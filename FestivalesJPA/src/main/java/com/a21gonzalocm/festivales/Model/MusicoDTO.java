package com.a21gonzalocm.festivales.Model;

public class MusicoDTO {
    private String nombre;
    private String instrumento;
    private String sexo;
    private String nacionalidad;

    // Constructor
    public MusicoDTO(String nombre, String instrumento, String sexo, String nacionalidad) {
        this.nombre = nombre;
        this.instrumento = instrumento;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}