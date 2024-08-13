package com.pharmacy.modeadministration.application;

import com.pharmacy.modeadministration.domain.entity.ModeAdministration;
import com.pharmacy.modeadministration.domain.service.ModeAdministrationService;

public class CreateModeAdministrationUseCase {
    private final ModeAdministrationService modeAdministrationService;

    public CreateModeAdministrationUseCase(ModeAdministrationService modeAdministrationService) {
        this.modeAdministrationService = modeAdministrationService;
    }

    public void execute(ModeAdministration modeAdministration) {
        modeAdministrationService.createModeAdministration(modeAdministration);
    }
}
