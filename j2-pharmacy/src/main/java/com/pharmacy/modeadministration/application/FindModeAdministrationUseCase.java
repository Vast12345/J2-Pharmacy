package com.pharmacy.modeadministration.application;

import java.util.Optional;

import com.pharmacy.modeadministration.domain.entity.ModeAdministration;
import com.pharmacy.modeadministration.domain.service.ModeAdministrationService;

public class FindModeAdministrationUseCase {
    private final ModeAdministrationService modeAdministrationService;

    public FindModeAdministrationUseCase(ModeAdministrationService modeAdministrationService) {
        this.modeAdministrationService = modeAdministrationService;
    }

    public Optional<ModeAdministration> execute(Long id) {
        return modeAdministrationService.findModeAdminstration(id);
    }
}
