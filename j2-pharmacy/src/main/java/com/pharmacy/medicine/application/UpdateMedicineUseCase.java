package com.pharmacy.medicine.application;

import java.util.Optional;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class UpdateMedicineUseCase {
    private final MedicineService medicineService;

    public UpdateMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public Optional<Medicine> execute(Long id, String proceedings, String name, String healthRegister, String description, String descriptionShort, String nameRol, Long codeModeAdmin, Long codeAp, Long codeUm, Long codeLab) {
        return medicineService.updateMedicine(id, proceedings, name, healthRegister, description, descriptionShort, nameRol, codeModeAdmin, codeAp, codeUm, codeLab);
    }
}
