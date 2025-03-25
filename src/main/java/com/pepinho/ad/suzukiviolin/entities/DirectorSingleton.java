package com.pepinho.ad.suzukiviolin.entities;

import java.util.Objects;

public class DirectorSingleton {
    private String nome;
    private String apelidos;
    private String email;
    private Integer idade;

    private static volatile DirectorSingleton instance;

    private DirectorSingleton() {
    }

    private DirectorSingleton(String nome, String apelidos, String email, Integer idade) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.email = email;
        this.idade = idade;
    }

    public static DirectorSingleton getInstance() {
        if (instance == null) {
            instance = new DirectorSingleton();
        }
        return instance;
    }

    public static DirectorSingleton getInstance(String nome, String apelidos, String email, Integer idade) {
        if (instance == null) {
            synchronized (DirectorSingleton.class) {
                if (instance == null) {
                    instance = new DirectorSingleton(nome, apelidos, email, idade);
                }
            }
        }
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorSingleton that = (DirectorSingleton) o;
        return Objects.equals(nome, that.nome) && Objects.equals(apelidos, that.apelidos) && Objects.equals(email, that.email) && Objects.equals(idade, that.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, apelidos, email, idade);
    }

    @Override
    public String toString() {
        return "DirectorSingleton{" +
                "nome='" + nome + '\'' +
                ", apelidos='" + apelidos + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
