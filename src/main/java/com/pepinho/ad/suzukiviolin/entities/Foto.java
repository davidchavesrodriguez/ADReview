package com.pepinho.ad.suzukiviolin.entities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Foto {

    private String nombre;
    private String path;

    private byte[] picture;

    public Foto() {
    }

    public Foto(String name, String path) {
        this.nombre = name;
        this.path = path;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPath() {
        return path;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    private void setPicture(String foto) {
        if(foto != null && !foto.isEmpty()  && foto.startsWith("data:image")) {
            String[] partes = foto.split(",");
            String base64 = partes[1];
            this.picture = Base64.getDecoder().decode(base64);
            this.path = foto;
        } else if (foto != null && !foto.isEmpty() && Files.exists(Paths.get(foto))) {
            try (var is = Files.newInputStream(Paths.get(foto))) {
                this.picture =is.readAllBytes();
                this.path = foto;
            } catch (IOException e) {
                System.out.println("Error al cargar la imagen");
            }
        }
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getBase64() {
        return Base64.getEncoder().encodeToString(picture);
    }

    public void setBase64(String base64) {
        if(base64 != null && !base64.isEmpty()) {
            this.picture = Base64.getDecoder().decode(base64);
        }
    }

    public void setFoto(String foto) {
        setPicture(foto);
    }

    public String getFoto() {
        return path;
    }

    @Override
    public String toString() {
        return "[" + nombre + "] " + path;
    }
}
