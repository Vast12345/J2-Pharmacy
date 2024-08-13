package com.pharmacy.modeadministration.application;

import com.pharmacy.modeadministration.domain.service.ModeAdministrationService;

public class DeleteModeAdministrationUseCase {
        private final ModeAdministrationService modeAdministrationService;

    public DeleteModeAdministrationUseCase(ModeAdministrationService modeAdministrationService) {
        this.modeAdministrationService = modeAdministrationService;
    }

    public void execute(Long id) {
        modeAdministrationService.deleteModeAdministration(id);
    }
}
