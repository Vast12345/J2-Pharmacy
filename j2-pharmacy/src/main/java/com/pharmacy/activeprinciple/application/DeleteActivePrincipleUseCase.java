package com.pharmacy.activeprinciple.application;

import com.pharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class DeleteActivePrincipleUseCase {
    private final ActivePrincipleService activePrincipleService;

    public DeleteActivePrincipleUseCase(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public void execute(Long id) {
        activePrincipleService.deleteActivePrinciple(id);
    }
}
