package com.pharmacy.unitmeasurement.domain.entity;

import java.text.MessageFormat;

public class UnitMeasurement {
    private Long idUm;
    private String nameUm;
    public UnitMeasurement() {
    }
    public UnitMeasurement(Long idUm, String nameUm) {
        this.idUm = idUm;
        this.nameUm = nameUm;
    }
    public Long getIdUm() {
        return idUm;
    }
    public void setIdUm(Long idUm) {
        this.idUm = idUm;
    }
    public String getNameUm() {
        return nameUm;
    }
    public void setNameUm(String nameUm) {
        this.nameUm = nameUm;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}", this.idUm, this.nameUm);
        return data;
    }
}
