package com.a21gonzalocm.festivales.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Banda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "banda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Musico> musicos = new HashSet<>();

    @Embedded
    private TipoMusica tipoMusica;

    @Lob
    private byte[] logo;

    @Lob
    private String descripcion;

    private LocalDate fechaCreacion;


    public Banda() {
    }


    public Banda(String nombre, Set<Musico> musicos, TipoMusica tipoMusica, byte[] logo, String descripcion, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.musicos = musicos;
        this.tipoMusica = tipoMusica;
        this.logo = logo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
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

    public TipoMusica getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(TipoMusica tipoMusica) {
        this.tipoMusica = tipoMusica;
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void addMusico(Musico musico){
        this.musicos.add(musico);
    }

    public void removeMusico(Musico musico){
        this.musicos.remove(musico);
    }

    public void addMusicos(Set<Musico> musicos){
        this.musicos.addAll(musicos);
    }

    public void removeMusicos(Set<Musico> musicos){
        this.musicos.removeAll(musicos);
    }

    @Override
    public String toString() {
        return "Banda{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", musicos=" +  musicos.stream().map(Musico::getNombre).reduce(", ", String::concat) +
                ", tipoMusica=" + tipoMusica +
                ", logo=" + Arrays.toString(logo) +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
