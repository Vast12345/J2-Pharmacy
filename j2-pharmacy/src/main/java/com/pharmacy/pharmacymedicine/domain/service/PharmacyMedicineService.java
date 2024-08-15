package com.pharmacy.pharmacymedicine.domain.service;

import java.util.Optional;

import com.pharmacy.pharmacymedicine.domain.entity.PharmacyMedicine;

public interface PharmacyMedicineService {
    void createPharmacyMedicine(PharmacyMedicine pharmacyMedicine);
    Optional<PharmacyMedicine> findPharmacyMedicine(Long idPharm, Long idMed);
    Optional<PharmacyMedicine> updatePharmacyMedicine(Long idPharm, Long idMed, Float price);
    void deletePharmacyMedicine(Long idPharm, Long idMed);
}
