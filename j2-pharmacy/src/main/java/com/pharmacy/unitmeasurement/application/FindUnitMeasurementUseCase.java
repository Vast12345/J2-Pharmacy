package com.pharmacy.unitmeasurement.application;

import java.util.Optional;

import com.pharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.pharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class FindUnitMeasurementUseCase {
    private final UnitMeasurementService unitMeasurementService;

    public FindUnitMeasurementUseCase(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public Optional<UnitMeasurement> execute(Long id) {
        return unitMeasurementService.findUnitMeasurement(id);
    }
}
