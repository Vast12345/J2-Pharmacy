package com.pharmacy.laboratory.application;

import com.pharmacy.laboratory.domain.service.LaboratoryService;

public class DeleteLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public DeleteLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(Long id) {
        laboratoryService.deleteLaboratory(id);
    }
}
