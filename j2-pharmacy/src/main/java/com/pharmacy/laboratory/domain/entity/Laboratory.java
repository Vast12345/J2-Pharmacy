package com.pharmacy.laboratory.domain.entity;

import java.text.MessageFormat;

public class Laboratory {
    private Long id;
    private String nameLab;
    private String codeCity;
    public Laboratory() {
    }
    public Laboratory(Long id, String nameLab, String codeCity) {
        this.id = id;
        this.nameLab = nameLab;
        this.codeCity = codeCity;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameLab() {
        return nameLab;
    }
    public void setNameLab(String nameLab) {
        this.nameLab = nameLab;
    }
    public String getCodeCity() {
        return codeCity;
    }
    public void setCodeCity(String codeCity) {
        this.codeCity = codeCity;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}\nCity Code: {2}", this.codeCity, this.nameLab, this.codeCity);
        return data;
    }
}
