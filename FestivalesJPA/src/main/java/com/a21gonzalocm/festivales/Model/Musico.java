package com.a21gonzalocm.festivales.Model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Musico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "banda_id")
    private Banda banda;

    private boolean esIndependiente;

    @Embedded
    private TipoMusica tipoMusica;

    @Lob
    private byte[] foto;

    private String descripcion;

    private int edad;

    private String nacionalidad;

    private String instrumento;

    private String sexo;

    public Musico() {
    }

    public Musico(String nombre, Banda banda, boolean esIndependiente, TipoMusica tipoMusica, byte[] foto, String descripcion, int edad, String nacionalidad, String instrumento, String sexo) {
        this.nombre = nombre;
        this.banda = banda;
        this.esIndependiente = esIndependiente;
        this.tipoMusica = tipoMusica;
        this.foto = foto;
        this.descripcion = descripcion;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.instrumento = instrumento;
        this.sexo = sexo;
    }

    public Musico(String nombre, String instrumento) {
        this.nombre = nombre;
        this.instrumento = instrumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public boolean isEsIndependiente() {
        return esIndependiente;
    }

    public void setEsIndependiente(boolean esIndependiente) {
        this.esIndependiente = esIndependiente;
    }

    public String getTipoMusica() {
        if (tipoMusica == null) return null;
        return tipoMusica.getGenero() + " " + tipoMusica.getSubgenero();
    }

    public void setTipoMusica(TipoMusica tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public void addBanda(Banda banda){
        this.banda = banda;
    }

    public void removeBanda(Banda banda){
        this.banda = null;
    }

    @Override
    public String toString() {
        return "Musico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", banda=" + ((banda!=null) ? banda.getNombre() : '-') +
                ", esIndependiente=" + esIndependiente +
                ", tipoMusica=" + tipoMusica +
                ", foto=" + Arrays.toString(foto) +
                ", descripcion='" + descripcion + '\'' +
                ", edad=" + edad +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", instrumento='" + instrumento + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
