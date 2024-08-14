package com.pharmacy.activeprinciple.application;

import java.util.Optional;

import com.pharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.pharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class FindActivePrincipleUseCase {
    private final ActivePrincipleService activePrincipleService;

    public FindActivePrincipleUseCase(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public Optional<ActivePrinciple> execute(Long id) {
        return activePrincipleService.findActivePrinciple(id);
    }
}
