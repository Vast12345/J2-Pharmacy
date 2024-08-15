package com.pharmacy.pharmacymedicine.application;

import com.pharmacy.pharmacymedicine.domain.entity.PharmacyMedicine;
import com.pharmacy.pharmacymedicine.domain.service.PharmacyMedicineService;

public class CreatePharmacyMedicineUseCase {
    private final PharmacyMedicineService pharmacyMedicineService;

    public CreatePharmacyMedicineUseCase(PharmacyMedicineService pharmacyMedicineService) {
        this.pharmacyMedicineService = pharmacyMedicineService;
    }

    public void execute(PharmacyMedicine pharmacyMedicine) {
        pharmacyMedicineService.createPharmacyMedicine(pharmacyMedicine);
    }
}
