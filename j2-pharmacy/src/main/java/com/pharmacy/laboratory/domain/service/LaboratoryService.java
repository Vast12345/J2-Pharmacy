package com.pharmacy.laboratory.domain.service;

import java.util.Optional;

import com.pharmacy.laboratory.domain.entity.Laboratory;

public interface LaboratoryService {
    void createLaboratory(Laboratory laboratory);
    Optional<Laboratory> findLaboratory(Long id);
    Optional<Laboratory> updateLaboratory(Long id, String name, String code);
    void deleteLaboratory(Long id);
}
