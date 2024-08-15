package com.pharmacy.unitmeasurement.application;

import java.util.Optional;

import com.pharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.pharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class UpdateUnitMeasurementUseCase {
    private final UnitMeasurementService unitMeasurementService;

    public UpdateUnitMeasurementUseCase(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public Optional<UnitMeasurement> execute(Long id, String name) {
        return unitMeasurementService.updateUnitMeasurement(id, name);
    }
}
