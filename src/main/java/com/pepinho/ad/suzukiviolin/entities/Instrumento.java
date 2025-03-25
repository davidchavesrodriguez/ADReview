package com.pepinho.ad.suzukiviolin.entities;

public class Instrumento {

    private Long idInstrumento;
    private String nombre;

    private String descripcion;

    public Instrumento() {
    }

    public Instrumento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(Long idInstrumento) {
        this.idInstrumento = idInstrumento;
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

    @Override
    public String toString() {
        return "[" + idInstrumento + "] " + nombre + " - " + descripcion;
    }
}
