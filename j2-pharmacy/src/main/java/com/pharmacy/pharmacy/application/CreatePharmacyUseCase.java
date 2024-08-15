package com.pharmacy.pharmacy.application;

import com.pharmacy.pharmacy.domain.entity.Pharmacy;
import com.pharmacy.pharmacy.domain.service.PharmacyService;

public class CreatePharmacyUseCase {
    private final PharmacyService pharmacyService;

    public CreatePharmacyUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public void execute(Pharmacy pharmacy) {
        pharmacyService.createPharmacy(pharmacy);
    }
}
