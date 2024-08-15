package com.pharmacy.pharmacy.application;

import java.util.Optional;

import com.pharmacy.pharmacy.domain.entity.Pharmacy;
import com.pharmacy.pharmacy.domain.service.PharmacyService;

public class FindPharmacyUseCase {
    private final PharmacyService pharmacyService;

    public FindPharmacyUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public Optional<Pharmacy> execute(Long id) {
        return pharmacyService.findPharmacy(id);
    }
}
