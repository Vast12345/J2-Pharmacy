package com.pharmacy.activeprinciple.domain.entity;

import java.text.MessageFormat;

public class ActivePrinciple {
    private Long idap;
    private String nameap;

    public ActivePrinciple() {
    }

    public ActivePrinciple(Long idap, String nameap) {
        this.idap = idap;
        this.nameap = nameap;
    }

    public Long getIdap() {
        return idap;
    }

    public void setIdap(Long idap) {
        this.idap = idap;
    }

    public String getNameap() {
        return nameap;
    }

    public void setNameap(String nameap) {
        this.nameap = nameap;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}", this.idap, this.nameap);
        return data;
    }
}
