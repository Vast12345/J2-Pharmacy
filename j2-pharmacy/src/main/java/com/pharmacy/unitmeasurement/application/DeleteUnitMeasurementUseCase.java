package com.pharmacy.unitmeasurement.application;

import com.pharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class DeleteUnitMeasurementUseCase {
    private final UnitMeasurementService unitMeasurementService;

    public DeleteUnitMeasurementUseCase(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void execute(Long id) {
        unitMeasurementService.deleteUnitMeasurement(id);
    }
}
