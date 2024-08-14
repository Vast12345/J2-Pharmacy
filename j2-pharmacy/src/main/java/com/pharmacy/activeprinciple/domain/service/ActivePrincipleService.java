package com.pharmacy.activeprinciple.domain.service;

import java.util.Optional;

import com.pharmacy.activeprinciple.domain.entity.ActivePrinciple;

public interface ActivePrincipleService {
    void createActivePrinciple(ActivePrinciple activePrinciple);
    Optional<ActivePrinciple> findActivePrinciple(Long id);
    Optional<ActivePrinciple> updateActivePrinciple(Long id, String value);
    void deleteActivePrinciple(Long id);
}
