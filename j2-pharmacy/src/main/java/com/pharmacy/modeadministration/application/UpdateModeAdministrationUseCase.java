package com.pharmacy.modeadministration.application;

import java.util.Optional;

import com.pharmacy.modeadministration.domain.entity.ModeAdministration;
import com.pharmacy.modeadministration.domain.service.ModeAdministrationService;

public class UpdateModeAdministrationUseCase {
    private final ModeAdministrationService modeAdministrationService;

    public UpdateModeAdministrationUseCase(ModeAdministrationService modeAdministrationService) {
        this.modeAdministrationService = modeAdministrationService;
    }

    public Optional<ModeAdministration> execute(Long id, String value) {
        return modeAdministrationService.updateModeAdministration(id, value);
    }
}
