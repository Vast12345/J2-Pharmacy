package com.pharmacy.pharmacy.application;

import java.util.Optional;

import com.pharmacy.pharmacy.domain.entity.Pharmacy;
import com.pharmacy.pharmacy.domain.service.PharmacyService;

public class UpdatePharmacyUseCase {
    private final PharmacyService pharmacyService;

    public UpdatePharmacyUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public Optional<Pharmacy> execute(Long id, String name, String address, Float iong, Float lat, String code, String logo) {
        return pharmacyService.updatePharmacy(id, name, address, iong, lat, code, logo);
    }
}
