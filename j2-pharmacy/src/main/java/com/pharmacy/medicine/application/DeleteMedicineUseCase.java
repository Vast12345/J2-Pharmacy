package com.pharmacy.medicine.application;

import com.pharmacy.medicine.domain.service.MedicineService;

public class DeleteMedicineUseCase {
    private final MedicineService medicineService;

    public DeleteMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(Long id) {
        medicineService.deleteMedicine(id);
    }
}
