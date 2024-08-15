package com.pharmacy.unitmeasurement.application;

import com.pharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.pharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class CreateUnitMeasurementUseCase {
    private final UnitMeasurementService unitMeasurementService;

    public CreateUnitMeasurementUseCase(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void execute(UnitMeasurement unitMeasurement) {
        unitMeasurementService.createUnitMeasurement(unitMeasurement);
    }
}
