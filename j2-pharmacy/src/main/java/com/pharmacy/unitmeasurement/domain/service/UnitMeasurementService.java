package com.pharmacy.unitmeasurement.domain.service;

import java.util.Optional;

import com.pharmacy.unitmeasurement.domain.entity.UnitMeasurement;

public interface UnitMeasurementService {
    void createUnitMeasurement(UnitMeasurement unitMeasurement);
    Optional<UnitMeasurement> findUnitMeasurement(Long id);
    Optional<UnitMeasurement> updateUnitMeasurement(Long id, String name);
    void deleteUnitMeasurement(Long id);
}
