package com.pharmacy.medicine.application;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class CreateMedicineUseCase {
    private final MedicineService medicineService;

    public CreateMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(Medicine medicine) {
        medicineService.createMedicine(medicine);
    }
}
