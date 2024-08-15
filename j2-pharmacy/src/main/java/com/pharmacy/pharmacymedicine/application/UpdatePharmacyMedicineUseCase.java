package com.pharmacy.pharmacymedicine.application;

import java.util.Optional;

import com.pharmacy.pharmacymedicine.domain.entity.PharmacyMedicine;
import com.pharmacy.pharmacymedicine.domain.service.PharmacyMedicineService;

public class UpdatePharmacyMedicineUseCase {
    private final PharmacyMedicineService pharmacyMedicineService;

    public UpdatePharmacyMedicineUseCase(PharmacyMedicineService pharmacyMedicineService) {
        this.pharmacyMedicineService = pharmacyMedicineService;
    }

    public Optional<PharmacyMedicine> execute(Long idPharm, Long idMed, Float price) {
        return pharmacyMedicineService.updatePharmacyMedicine(idPharm, idMed, price);
    }
}   
