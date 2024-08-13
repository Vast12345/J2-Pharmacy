package com.pharmacy.modeadministration.domain.service;

import java.util.Optional;

import com.pharmacy.modeadministration.domain.entity.ModeAdministration;

public interface ModeAdministrationService {
    void createModeAdministration(ModeAdministration modeadministration);
    Optional<ModeAdministration> findModeAdminstration(Long id);
    Optional<ModeAdministration> updateModeAdministration(Long id, String value);
    void deleteModeAdministration(Long id);
}
