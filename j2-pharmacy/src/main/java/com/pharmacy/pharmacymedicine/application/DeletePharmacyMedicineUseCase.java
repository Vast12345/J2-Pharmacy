package com.pharmacy.pharmacymedicine.application;

import com.pharmacy.pharmacymedicine.domain.service.PharmacyMedicineService;

public class DeletePharmacyMedicineUseCase {
    private final PharmacyMedicineService pharmacyMedicineService;

    public DeletePharmacyMedicineUseCase(PharmacyMedicineService pharmacyMedicineService) {
        this.pharmacyMedicineService = pharmacyMedicineService;
    }

    public void execute(Long idPharm, Long idMed) {
        pharmacyMedicineService.deletePharmacyMedicine(idPharm, idMed);
    }
}
