package com.pharmacy.city.domain.entity;

import java.text.MessageFormat;

public class City {
    private String codeCity;
    private String nameCity;
    private String codeReg;

    
    public City() {
    }
    
    public City(String codeCity, String nameCity, String codeReg) {
        this.codeCity = codeCity;
        this.nameCity = nameCity;
        this.codeReg = codeReg;
    }

    public String getCodeCity() {
        return codeCity;
    }
    public void setCodeCity(String codeCity) {
        this.codeCity = codeCity;
    }
    public String getNameCity() {
        return nameCity;
    }
    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
    public String getCodeReg() {
        return codeReg;
    }
    public void setCodeReg(String codeReg) {
        this.codeReg = codeReg;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}\nRegion Code: {2}", this.codeCity, this.nameCity, this.codeReg);
        return data;
    }
}
