package com.pharmacy.medicine.domain.service;

import java.util.Optional;

import com.pharmacy.medicine.domain.entity.Medicine;


public interface MedicineService {
    void createMedicine(Medicine Medicine);
    Optional<Medicine> findMedicine(Long id);
    Optional<Medicine> updateMedicine(Long id, String proceedings, String nameMedicine, String healthRegister, String description, String descriptionShort, String nameRol, Long codeModeAdmin, Long codeAp, Long codeUm, Long codeLab);
    void deleteMedicine(Long id);
}
