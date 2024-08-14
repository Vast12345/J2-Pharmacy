package com.pharmacy.country.domain.entity;

import java.text.MessageFormat;

public class Country {
    private String codeCountry;
    private String nameCountry;

    public Country() {
    }
    public Country(String codeCountry, String nameCountry) {
        this.codeCountry = codeCountry;
        this.nameCountry = nameCountry;
    }
    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}", this.codeCountry, this.nameCountry);
        return data;
    }
}
