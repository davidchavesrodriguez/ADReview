package com.pepinho.ad.suzukiviolin.entities;


import jakarta.persistence.*;

import java.util.List;

public class PiezaMusical {

    private Long idPieza;
    private String nombre;
    private MusicGenre generoMusical;

    public PiezaMusical() {
    }

    public PiezaMusical(String nombre) {
        this.nombre = nombre;
    }

    public PiezaMusical(Long idPieza, String nombre) {
        this.idPieza = idPieza;
        this.nombre = nombre;
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


    @Override
    public String toString() {
        return "[" + idPieza + "] " + nombre + generoMusical;
    }
}
