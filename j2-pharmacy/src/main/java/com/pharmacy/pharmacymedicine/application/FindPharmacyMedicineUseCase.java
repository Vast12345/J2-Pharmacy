package com.pharmacy.pharmacymedicine.application;

import java.util.Optional;

import com.pharmacy.pharmacymedicine.domain.entity.PharmacyMedicine;
import com.pharmacy.pharmacymedicine.domain.service.PharmacyMedicineService;

public class FindPharmacyMedicineUseCase {
    private final PharmacyMedicineService pharmacyMedicineService;

    public FindPharmacyMedicineUseCase(PharmacyMedicineService pharmacyMedicineService) {
        this.pharmacyMedicineService = pharmacyMedicineService;
    }

    public Optional<PharmacyMedicine> execute(Long idPharm, Long idMed) {
        return pharmacyMedicineService.findPharmacyMedicine(idPharm, idMed);
    }
}
