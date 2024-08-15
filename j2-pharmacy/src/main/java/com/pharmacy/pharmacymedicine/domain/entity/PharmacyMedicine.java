package com.pharmacy.pharmacymedicine.domain.entity;

import java.text.MessageFormat;

public class PharmacyMedicine {
    private Long idPharmacy;
    private Long idMedicine;
    private float price;
    public PharmacyMedicine() {
    }
    public PharmacyMedicine(Long idPharmacy, Long idMedicine, float price) {
        this.idPharmacy = idPharmacy;
        this.idMedicine = idMedicine;
        this.price = price;
    }
    public Long getIdPharmacy() {
        return idPharmacy;
    }
    public void setIdPharmacy(Long idPharmacy) {
        this.idPharmacy = idPharmacy;
    }
    public Long getIdMedicine() {
        return idMedicine;
    }
    public void setIdMedicine(Long idMedicine) {
        this.idMedicine = idMedicine;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id Pharmacy: {0}\nId Medicine: {1}\nPrice: {2}", this.idPharmacy, this.idMedicine, this.price);
        return data;
    }
}
