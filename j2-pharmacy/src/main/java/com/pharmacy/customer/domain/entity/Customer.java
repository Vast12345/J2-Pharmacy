package com.pharmacy.customer.domain.entity;

import java.sql.Date;
import java.text.MessageFormat;

public class Customer {
    private String idCustomer;
    private String nameCustomer;
    private String lastNameCustomer;
    private String emailCustomer;
    private Date birthdate;
    private float lon;
    private float latitud;
    private String codeCityCustomer;

    
    public Customer() {
    }
    
    public Customer(String idCustomer, String nameCustomer, String lastNameCustomer, String emailCustomer,
            Date birthdate, float lon, float latitud, String codeCityCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.emailCustomer = emailCustomer;
        this.birthdate = birthdate;
        this.lon = lon;
        this.latitud = latitud;
        this.codeCityCustomer = codeCityCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
    public String getNameCustomer() {
        return nameCustomer;
    }
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    public String getLastNameCustomer() {
        return lastNameCustomer;
    }
    public void setLastNameCustomer(String lastNameCustomer) {
        this.lastNameCustomer = lastNameCustomer;
    }
    public String getEmailCustomer() {
        return emailCustomer;
    }
    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public float getLon() {
        return lon;
    }
    public void setLon(float lon) {
        this.lon = lon;
    }
    public float getLatitud() {
        return latitud;
    }
    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }
    public String getCodeCityCustomer() {
        return codeCityCustomer;
    }
    public void setCodeCityCustomer(String codeCityCustomer) {
        this.codeCityCustomer = codeCityCustomer;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}\nLast Name: {2}\nEmail: {3}\nBirthdate: {4}\nLon: {5}\nLatitud: {6}\nCity Code: {7}", this.idCustomer, this.nameCustomer, this.lastNameCustomer, this.emailCustomer, this.birthdate, this.lon, this.latitud, this.codeCityCustomer);
        return data;
    }

    
}
