package com.pharmacy.region.domain.entity;

import java.text.MessageFormat;

public class Region {
    private String codeReg;
    private String nameReg;
    private String codeCountry;

    public Region() {
    }

    public Region(String codeReg, String nameReg, String codeCountry) {
        this.codeReg = codeReg;
        this.nameReg = nameReg;
        this.codeCountry = codeCountry;
    }
    public String getCodeReg() {
        return codeReg;
    }
    public void setCodeReg(String codeReg) {
        this.codeReg = codeReg;
    }
    public String getNameReg() {
        return nameReg;
    }
    public void setNameReg(String nameReg) {
        this.nameReg = nameReg;
    }
    public String getCodeCountry() {
        return codeCountry;
    }
    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }
    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}\nCountryCode: {2}", this.codeReg, this.nameReg, this.codeCountry);
        return data;
    }
    
}
