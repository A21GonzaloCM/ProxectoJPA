package com.a21gonzalocm.festivales.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @ManyToMany
    @JoinTable(name = "festival_musico",
            joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "musico_id"))
    private Set<Musico> musicos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "festival_banda",
            joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "banda_id"))
    private Set<Banda> bandas = new HashSet<>();

    @Lob
    private byte[] logo;

    @Lob
    private String descripcion;

    private String lugar;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Lob
    private byte[] cartel;

    private String tipo;

    private String organizador;

    private String patrocinador;

    private String web;

    public Festival() {
    }


    public Festival(String nombre, Set<Musico> musicos, Set<Banda> bandas, byte[] logo, String descripcion, String lugar, LocalDate fechaInicio, LocalDate fechaFin, byte[] cartel, String tipo, String organizador, String patrocinador, String web) {
        this.nombre = nombre;
        this.musicos = musicos;
        this.bandas = bandas;
        this.logo = logo;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cartel = cartel;
        this.tipo = tipo;
        this.organizador = organizador;
        this.patrocinador = patrocinador;
        this.web = web;
    }

    public Set<Banda> getBandas() {
        return bandas;
    }

    public void setBandas(Set<Banda> bandas) {
        this.bandas = bandas;
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

    public Set<Musico> getMusicos() {
        return musicos;
    }

    public void setMusicos(Set<Musico> musicos) {
        this.musicos = musicos;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public byte[] getCartel() {
        return cartel;
    }

    public void setCartel(byte[] cartel) {
        this.cartel = cartel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void addBanda(Banda banda){
        this.bandas.add(banda);
    }

    public void removeBanda(Banda banda){
        this.bandas.remove(banda);
    }

    public void addMusico(Musico musico){
        this.musicos.add(musico);
    }

    public void removeMusico(Musico musico){
        this.musicos.remove(musico);
    }

    @Override
    public String toString() {
        return "Festival{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", musicos=" + musicos +
                ", bandas=" + bandas +
                ", logo=" + logo +
                ", descripcion='" + descripcion + '\'' +
                ", lugar='" + lugar + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cartel=" + cartel +
                ", tipo='" + tipo + '\'' +
                ", organizador='" + organizador + '\'' +
                ", patrocinador='" + patrocinador + '\'' +
                ", web='" + web + '\'' +
                '}';
    }
}
