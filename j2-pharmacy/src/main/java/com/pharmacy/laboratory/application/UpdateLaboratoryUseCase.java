package com.pharmacy.laboratory.application;

import java.util.Optional;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;

public class UpdateLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public UpdateLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public Optional<Laboratory> execute(Long id, String name, String code) {
        return laboratoryService.updateLaboratory(id, name, code);
    }
}
