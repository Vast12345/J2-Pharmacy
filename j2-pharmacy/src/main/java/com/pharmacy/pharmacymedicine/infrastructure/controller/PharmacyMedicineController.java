package com.pharmacy.pharmacymedicine.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.pharmacymedicine.application.CreatePharmacyMedicineUseCase;
import com.pharmacy.pharmacymedicine.application.DeletePharmacyMedicineUseCase;
import com.pharmacy.pharmacymedicine.application.FindPharmacyMedicineUseCase;
import com.pharmacy.pharmacymedicine.application.UpdatePharmacyMedicineUseCase;
import com.pharmacy.pharmacymedicine.domain.entity.PharmacyMedicine;
import com.pharmacy.pharmacymedicine.domain.service.PharmacyMedicineService;
import com.pharmacy.pharmacymedicine.infrastructure.repository.PharmacyMedicineRepository;

public class PharmacyMedicineController {
    PharmacyMedicineService pharmacyMedicineService;
    CreatePharmacyMedicineUseCase createPharmacyMedicineUseCase;
    FindPharmacyMedicineUseCase findPharmacyMedicineUseCase;
    UpdatePharmacyMedicineUseCase updatePharmacyMedicineUseCase;
    DeletePharmacyMedicineUseCase deletePharmacyMedicineUseCase;

    public PharmacyMedicineController() {
        pharmacyMedicineService = new PharmacyMedicineRepository();
        createPharmacyMedicineUseCase = new CreatePharmacyMedicineUseCase(pharmacyMedicineService);
        findPharmacyMedicineUseCase = new FindPharmacyMedicineUseCase(pharmacyMedicineService);
        updatePharmacyMedicineUseCase = new UpdatePharmacyMedicineUseCase(pharmacyMedicineService);
        deletePharmacyMedicineUseCase = new DeletePharmacyMedicineUseCase(pharmacyMedicineService);
    }

    public void pharmacyMedicineMenu() {
        String opciones = "1. Add Pharmacy Medicine\n2. Search Pharmacy Medicine\n3. Update Pharmacy Medicine\n4. Delete Pharmacy Medicine\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addPharmacyMedicine();
                    break;
                case 2:
                    searchPharmacyMedicine();
                    break;
                case 3:
                    amendPharmacyMedicine();
                    break;
                case 4:
                    removePharmacyMedicine();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addPharmacyMedicine() {
        Long idPharm = Long.parseLong(JOptionPane.showInputDialog(null, "Add Pharmacy ID: "));
        Long idMed = Long.parseLong(JOptionPane.showInputDialog(null, "Add Medicine ID: "));
        Float price = Float.parseFloat(JOptionPane.showInputDialog(null, "Add Price: "));
        PharmacyMedicine pharmacyMedicine = new PharmacyMedicine();
        pharmacyMedicine.setIdPharmacy(idPharm);
        pharmacyMedicine.setIdMedicine(idMed);
        pharmacyMedicine.setPrice(price);
        createPharmacyMedicineUseCase.execute(pharmacyMedicine);
    }

    public void searchPharmacyMedicine() {
        try {
            Long idPharm = Long.parseLong(JOptionPane.showInputDialog(null, "Add Pharmacy ID: "));
            Long idMed = Long.parseLong(JOptionPane.showInputDialog(null, "Add Medicine ID: "));
            findPharmacyMedicineUseCase.execute(idPharm, idMed).ifPresentOrElse(foundPharmMed -> {
                JOptionPane.showMessageDialog(null, foundPharmMed.toString());
                foundPharmMed.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendPharmacyMedicine() {
        JPanel panel = new JPanel();

        JTextField idPharmField = new JTextField(10);
        JTextField idMedField = new JTextField(10);
        JTextField priceField = new JTextField(10);

        panel.add(new JLabel("Pharmacy ID:"));
        panel.add(idPharmField);
        panel.add(new JLabel("Medicine ID:"));
        panel.add(idMedField);
        panel.add(new JLabel("Price: "));
        panel.add(priceField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Long idPharm = Long.parseLong(idPharmField.getText());
                Long idMed = Long.parseLong(idMedField.getText());
                Float price = Float.parseFloat(priceField.getText());

                updatePharmacyMedicineUseCase.execute(idPharm, idMed, price).ifPresentOrElse(updatedPharmMed -> {
                    JOptionPane.showMessageDialog(null, updatedPharmMed.toString());
                }, () -> {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removePharmacyMedicine() {
        try {
            Long idPharm = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Pharmacy ID: "));
            Long idMed = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Medicine ID: "));
            deletePharmacyMedicineUseCase.execute(idPharm, idMed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
