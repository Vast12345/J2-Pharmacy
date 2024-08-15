package com.pharmacy.laboratory.application;

import java.util.Optional;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;

public class FindLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public FindLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public Optional<Laboratory> execute(Long id) {
        return laboratoryService.findLaboratory(id);
    }
}
