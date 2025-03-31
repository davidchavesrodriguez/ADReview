package com.pepinho.ad.suzukiviolin.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Autor {

    @Id
    private Long idAutor;


    private String nombre;
    private String apellidos;
    private String codigoNacionalidad;
    private LocalDate fechaNacimiento;
    private LocalDate fechaDefuncion;

    private String biografia;

    private MusicGenre generoMusical;

    public Autor() {
    }

    public Autor(String nombre, String apellido, String codigoNacionalidad, LocalDate fechaNacimiento, LocalDate fechaDefuncion) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.codigoNacionalidad = codigoNacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
    }

    public Autor(String nombre, String apellido, String codigoNacionalidad, LocalDate fechaNacimiento,
                 LocalDate fechaDefuncion, String biografia) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.codigoNacionalidad = codigoNacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
        this.biografia = biografia;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    public void setCodigoNacionalidad(String codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(LocalDate fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public MusicGenre getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(MusicGenre generoMusical) {
        this.generoMusical = generoMusical;
    }

    @Override
    public String toString() {
        return "[" + idAutor + "] " + nombre + ' ' + apellidos + ", compositor " + generoMusical + " (" + codigoNacionalidad + ')' +
                " [" + fechaNacimiento + " - " + (fechaDefuncion != null ? fechaDefuncion : "") + "]: " + (biografia != null ? biografia : "");
    }
}
