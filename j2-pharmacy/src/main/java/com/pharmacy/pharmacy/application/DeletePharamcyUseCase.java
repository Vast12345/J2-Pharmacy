package com.pharmacy.pharmacy.application;

import com.pharmacy.pharmacy.domain.service.PharmacyService;

public class DeletePharamcyUseCase {
    private final PharmacyService pharmacyService;

    public DeletePharamcyUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public void execute(Long id) {
        pharmacyService.deletePharmacy(id);
    }
}
