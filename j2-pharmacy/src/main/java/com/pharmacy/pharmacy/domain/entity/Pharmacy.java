package com.pharmacy.pharmacy.domain.entity;

import java.text.MessageFormat;

public class Pharmacy {
    private Long idPharmacy;
    private String namePharmacy;
    private String addressPharmacy;
    private float iong;
    private float latPharmacy;
    private String codeCityPharm;
    private String logoPharmacy;
    public Pharmacy() {
    }
    public Pharmacy(Long idPharmacy, String namePharmacy, String addressPharmacy, float iong, float latPharmacy,
            String codeCityPharm, String logoPharmacy) {
        this.idPharmacy = idPharmacy;
        this.namePharmacy = namePharmacy;
        this.addressPharmacy = addressPharmacy;
        this.iong = iong;
        this.latPharmacy = latPharmacy;
        this.codeCityPharm = codeCityPharm;
        this.logoPharmacy = logoPharmacy;
    }
    public Long getIdPharmacy() {
        return idPharmacy;
    }
    public void setIdPharmacy(Long idPharmacy) {
        this.idPharmacy = idPharmacy;
    }
    public String getNamePharmacy() {
        return namePharmacy;
    }
    public void setNamePharmacy(String namePharmacy) {
        this.namePharmacy = namePharmacy;
    }
    public String getAddressPharmacy() {
        return addressPharmacy;
    }
    public void setAddressPharmacy(String addressPharmacy) {
        this.addressPharmacy = addressPharmacy;
    }
    public float getIong() {
        return iong;
    }
    public void setIong(float iong) {
        this.iong = iong;
    }
    public float getLatPharmacy() {
        return latPharmacy;
    }
    public void setLatPharmacy(float latPharmacy) {
        this.latPharmacy = latPharmacy;
    }
    public String getCodeCityPharm() {
        return codeCityPharm;
    }
    public void setCodeCityPharm(String codeCityPharm) {
        this.codeCityPharm = codeCityPharm;
    }
    public String getLogoPharmacy() {
        return logoPharmacy;
    }
    public void setLogoPharmacy(String logoPharmacy) {
        this.logoPharmacy = logoPharmacy;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}\nAddress: {2}\nIong: {3}\nLat Pharmacy: {4}\nCity Code: {5}\nLogo: {6}", this.idPharmacy, this.namePharmacy, this.addressPharmacy, this.iong, this.latPharmacy, this.codeCityPharm, this.logoPharmacy);
        return data;
    }
}
