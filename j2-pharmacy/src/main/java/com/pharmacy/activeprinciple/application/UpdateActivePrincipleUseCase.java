package com.pharmacy.activeprinciple.application;

import java.util.Optional;

import com.pharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.pharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class UpdateActivePrincipleUseCase {
    private final ActivePrincipleService activePrincipleService;

    public UpdateActivePrincipleUseCase(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public Optional<ActivePrinciple> execute(Long id, String value) {
        return activePrincipleService.updateActivePrinciple(id, value);
    }
}
