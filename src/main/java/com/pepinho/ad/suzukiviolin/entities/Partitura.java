package com.pepinho.ad.suzukiviolin.entities;


import jakarta.persistence.*;

import java.io.BufferedInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Entity
public class Partitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartitura;

    private String nombre;
    private Tonality armadura;

    private byte[] partitura;

    /**
     * Audio de la partitura en formato MP3
     */
    private byte[] audio;

    @ManyToOne
    @JoinColumn(name = "idPieza")
    private PiezaMusical piezaMusical;

    public Partitura() {
    }

    public Partitura(String nombre) {
        this.nombre = nombre;
    }

    public Partitura(Long idPartitura, String nombre, Tonality armadura, byte[] partitura) {
        this.idPartitura = idPartitura;
        this.nombre = nombre;
        this.armadura = armadura;
        this.partitura = partitura;
    }

    public Partitura(Tonality armadura, byte[] partitura) {
        this.armadura = armadura;
        this.partitura = partitura;
    }

    public Long getIdPartitura() {
        return idPartitura;
    }

    public void setIdPartitura(Long idPartitura) {
        this.idPartitura = idPartitura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tonality getArmadura() {
        return armadura;
    }

    public void setArmadura(Tonality armadura) {
        this.armadura = armadura;
    }


    public byte[] getAudio() {
        return audio;
    }

    public void setAudio(byte[] audio) {
        this.audio = audio;
    }

    public void addAudio(byte[] audio) {
        this.audio = audio;
    }

    public void removeAudio() {
        this.audio = null;
    }

    public void clearAudio() {
        this.audio = null;
    }

    private void setAudio(String ruta) {
        if (ruta != null && !ruta.isEmpty() && Files.exists(Paths.get(ruta))) {
            try (BufferedInputStream is = new BufferedInputStream(Files.newInputStream(Paths.get(ruta)))) {
                this.audio = is.readAllBytes();
            } catch (Exception e) {
                System.out.println("Error al cargar el audio");
            }
        }
    }

    @Override
    public String toString() {
        return "[" + idPartitura + "]: " + nombre + " en " + armadura;
    }

}
