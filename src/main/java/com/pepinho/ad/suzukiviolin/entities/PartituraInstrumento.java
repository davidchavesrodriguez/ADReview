package com.pepinho.ad.suzukiviolin.entities;

import jakarta.persistence.*;

public class PartituraInstrumento {

    private Integer orden;

    public PartituraInstrumento() {
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "[idPartituraInstrumento]";
    }
}
