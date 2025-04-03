package com.pepinho.ad.suzukiviolin.entities;

import jakarta.persistence.*;

@Entity
public class RecursoMusical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecurso;

    private String nomeRecurso;

    @ManyToOne
    @JoinColumn(name = "idPieza")
    private PiezaMusical piezaMusical;

    public RecursoMusical() {
    }

    public RecursoMusical(Long idRecurso, String nomeRecurso) {
        this.idRecurso = idRecurso;
        this.nomeRecurso = nomeRecurso;
    }

    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNomeRecurso() {
        return nomeRecurso;
    }

    public void setNomeRecurso(String nomeRecurso) {
        this.nomeRecurso = nomeRecurso;
    }
}
