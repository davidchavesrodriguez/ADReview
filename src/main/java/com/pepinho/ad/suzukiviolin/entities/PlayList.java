package com.pepinho.ad.suzukiviolin.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


public class PlayList {

    private Long idLista;

    private PlayListType tipo;

    private String nombre;

    private String descripcion;

    private LocalDateTime fechaCreacion;


    public PlayList() {
    }

    public PlayList(PlayListType tipo, String nombre, String descripcion, LocalDateTime fechaCreacion) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public PlayListType getTipoLista() {
        return tipo;
    }

    public void setTipoLista(PlayListType playListType) {
        this.tipo = playListType;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public PlayListType getTipo() {
        return tipo;
    }

    public void setTipo(PlayListType tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "[" + idLista + "] " + nombre + ", " + tipo + ", " +
                ": " + (descripcion!=null && !descripcion.isEmpty() ? descripcion : "sin descripción") +
                (fechaCreacion == null ? ", creada el " + fechaCreacion : "") + ".";
    }
}
