package com.pharmacy.laboratory.application;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;

public class CreateLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public CreateLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory laboratory) {
        laboratoryService.createLaboratory(laboratory);
    }
}
