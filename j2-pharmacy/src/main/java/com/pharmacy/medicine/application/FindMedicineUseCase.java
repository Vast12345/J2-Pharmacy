package com.pharmacy.medicine.application;

import java.util.Optional;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class FindMedicineUseCase {
    private final MedicineService medicineService;

    public FindMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public Optional<Medicine> execute(Long id) {
        return medicineService.findMedicine(id);
    }
}
