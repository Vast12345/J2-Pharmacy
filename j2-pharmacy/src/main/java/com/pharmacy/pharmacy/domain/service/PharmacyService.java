package com.pharmacy.pharmacy.domain.service;

import java.util.Optional;

import com.pharmacy.pharmacy.domain.entity.Pharmacy;

public interface PharmacyService {
    void createPharmacy(Pharmacy pharmacy);
    Optional<Pharmacy> findPharmacy(Long id);
    Optional<Pharmacy> updatePharmacy(Long id, String name, String address, float iong, float lat, String code, String logo);
    void deletePharmacy(Long id);
}
