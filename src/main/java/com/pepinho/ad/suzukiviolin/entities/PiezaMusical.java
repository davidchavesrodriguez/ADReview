package com.pepinho.ad.suzukiviolin.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class PiezaMusical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPieza;

    private String nombre;
    private MusicGenre generoMusical;

    @ManyToOne
    @JoinColumn(name = "idAutor")
    private Autor autor;

    @OneToMany(mappedBy = "piezaMusical", cascade = CascadeType.ALL, orphanRemoval = true)
    @Basic(fetch = FetchType.LAZY)
    private List<RecursoMusical> recursos;

    @OneToMany(mappedBy = "piezaMusical", cascade = CascadeType.ALL, orphanRemoval = true)
    @Basic(fetch = FetchType.LAZY)
    private List<Partitura> partituras;

    public PiezaMusical() {
    }

    public PiezaMusical(String nombre) {
        this.nombre = nombre;
    }

    public PiezaMusical(Long idPieza, String nombre) {
        this.idPieza = idPieza;
        this.nombre = nombre;
    }

    public void removePiezaMusical() {

    }

    public Long getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(Long idPieza) {
        this.idPieza = idPieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MusicGenre getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(MusicGenre generoMusical) {
        this.generoMusical = generoMusical;
    }

    public void setAutor(Autor autor) {

    }

    @Override
    public String toString() {
        return "[" + idPieza + "] " + nombre + generoMusical;
    }


}
