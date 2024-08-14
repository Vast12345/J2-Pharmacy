package com.pharmacy.activeprinciple.application;

import com.pharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.pharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class CreateActivePrincipleUseCase {
    private final ActivePrincipleService activePrincipleService;

    public CreateActivePrincipleUseCase(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public void execute(ActivePrinciple activePrinciple) {
        activePrincipleService.createActivePrinciple(activePrinciple);
    }
}
