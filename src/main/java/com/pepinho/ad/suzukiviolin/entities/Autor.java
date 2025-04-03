package com.pepinho.ad.suzukiviolin.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "UUIDAutor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idAutor;

    @Column(nullable = false, length = 125)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String apellidos;

    @Column(name = "nacionalidad", length = 3)
    private String codigoNacionalidad;

    private LocalDate fechaNacimiento;
    private LocalDate fechaDefuncion;

    @Lob
    @Column(columnDefinition = "text") // Depende do SGBD
    @Basic(fetch = FetchType.LAZY)
    private String biografia;

    private MusicGenre generoMusical;

    @OneToMany(mappedBy = "autor")
    @Basic(fetch = FetchType.LAZY)
    private Set<PiezaMusical> piezas;

    public Autor() {
        piezas= new HashSet<>();
    }

    public Autor(String nombre, String apellido, String codigoNacionalidad, LocalDate fechaNacimiento, LocalDate fechaDefuncion) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.codigoNacionalidad = codigoNacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
        piezas= new HashSet<>();
    }

    public Autor(String nombre, String apellido, String codigoNacionalidad, LocalDate fechaNacimiento,
                 LocalDate fechaDefuncion, String biografia) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.codigoNacionalidad = codigoNacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
        this.biografia = biografia;
        piezas= new HashSet<>();
    }

    public void addPiezaMusical(PiezaMusical pieza){
        piezas.add(pieza);
        pieza.setAutor(this);
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
