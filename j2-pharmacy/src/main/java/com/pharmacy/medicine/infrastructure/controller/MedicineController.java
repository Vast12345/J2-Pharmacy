package com.pharmacy.medicine.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.medicine.application.CreateMedicineUseCase;
import com.pharmacy.medicine.application.DeleteMedicineUseCase;
import com.pharmacy.medicine.application.FindMedicineUseCase;
import com.pharmacy.medicine.application.UpdateMedicineUseCase;
import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;
import com.pharmacy.medicine.infrastructure.repository.MedicineRepository;

public class MedicineController {
    MedicineService medicineService;
    CreateMedicineUseCase createMedicineUseCase;
    FindMedicineUseCase findMedicineUseCase;
    UpdateMedicineUseCase updateMedicineUseCase;
    DeleteMedicineUseCase deleteMedicineUseCase;

    public MedicineController() {
        medicineService = new MedicineRepository();
        createMedicineUseCase = new CreateMedicineUseCase(medicineService);
        findMedicineUseCase = new FindMedicineUseCase(medicineService);
        updateMedicineUseCase = new UpdateMedicineUseCase(medicineService);
        deleteMedicineUseCase = new DeleteMedicineUseCase(medicineService);
    }

    public void addMedicine() {
        JPanel panel = new JPanel();

        JTextField proceedingsField = new JTextField(7);
        JTextField nameField = new JTextField(7);
        JTextField healthRegisterField = new JTextField(7);
        JTextField descriptionField = new JTextField(7);
        JTextField descriptionShortField = new JTextField(7);
        JTextField nameRolField = new JTextField(7);
        JTextField codeModeAdminField = new JTextField(7);
        JTextField codeApField = new JTextField(7);
        JTextField codeUmField = new JTextField(7);
        JTextField codeLabField = new JTextField(7);

        panel.add(new JLabel("Proceedings:"));
        panel.add(proceedingsField);
        panel.add(new JLabel("Medicine Name: "));
        panel.add(nameField);
        panel.add(new JLabel("Health Register: "));
        panel.add(healthRegisterField);
        panel.add(new JLabel("Description: "));
        panel.add(descriptionField);
        panel.add(new JLabel("Short Description: "));
        panel.add(descriptionShortField);
        panel.add(new JLabel("Medicine Rol Name: "));
        panel.add(nameRolField);
        panel.add(new JLabel("Mode Admin Code: "));
        panel.add(codeModeAdminField);
        panel.add(new JLabel("Active Principle Code: "));
        panel.add(codeApField);
        panel.add(new JLabel("Unit Measurement Code: "));
        panel.add(codeUmField);
        panel.add(new JLabel("Laboratory Code: "));
        panel.add(codeLabField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String proceedings = proceedingsField.getText();
                String name= nameField.getText();
                String healthRegister = healthRegisterField.getText();
                String description = descriptionField.getText();
                String descriptionShort = descriptionShortField.getText();
                String nameRol = nameRolField.getText();
                Long codeModeAdmin = Long.parseLong(codeModeAdminField.getText());
                Long codeAp = Long.parseLong(codeApField.getText());
                Long codeUm = Long.parseLong(codeUmField.getText());
                Long codeLab = Long.parseLong(codeLabField.getText());

                Medicine medicine = new Medicine();
                medicine.setProceedings(proceedings);
                medicine.setNameMedicine(name);
                medicine.setHealthRegister(healthRegister);
                medicine.setDescription(description);
                medicine.setDescriptionShort(descriptionShort);
                medicine.setNameRol(nameRol);
                medicine.setCodeModeAdmin(codeModeAdmin);
                medicine.setCodeAp(codeAp);
                medicine.setCodeUm(codeUm);
                medicine.setCodeLab(codeLab);
                createMedicineUseCase.execute(medicine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void searchMedicine() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Customer ID: "));
            findMedicineUseCase.execute(id).ifPresentOrElse(foundMedicine -> {
                JOptionPane.showMessageDialog(null, foundMedicine.toString());
                foundMedicine.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendMedicine() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(7);
        JTextField proceedingsField = new JTextField(7);
        JTextField nameField = new JTextField(7);
        JTextField healthRegisterField = new JTextField(7);
        JTextField descriptionField = new JTextField(7);
        JTextField descriptionShortField = new JTextField(7);
        JTextField nameRolField = new JTextField(7);
        JTextField codeModeAdminField = new JTextField(7);
        JTextField codeApField = new JTextField(7);
        JTextField codeUmField = new JTextField(7);
        JTextField codeLabField = new JTextField(7);

        panel.add(new JLabel("Medicine ID:"));
        panel.add(idField);
        panel.add(new JLabel("Proceedings:"));
        panel.add(proceedingsField);
        panel.add(new JLabel("Medicine Name: "));
        panel.add(nameField);
        panel.add(new JLabel("Health Register: "));
        panel.add(healthRegisterField);
        panel.add(new JLabel("Description: "));
        panel.add(descriptionField);
        panel.add(new JLabel("Short Description: "));
        panel.add(descriptionShortField);
        panel.add(new JLabel("Medicine Rol Name: "));
        panel.add(nameRolField);
        panel.add(new JLabel("Mode Admin Code: "));
        panel.add(codeModeAdminField);
        panel.add(new JLabel("Active Principle Code: "));
        panel.add(codeApField);
        panel.add(new JLabel("Unit Measurement Code: "));
        panel.add(codeUmField);
        panel.add(new JLabel("Laboratory Code: "));
        panel.add(codeLabField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Long id = Long.parseLong(idField.getText());
                String proceedings = proceedingsField.getText();
                String name= nameField.getText();
                String healthRegister = healthRegisterField.getText();
                String description = descriptionField.getText();
                String descriptionShort = descriptionShortField.getText();
                String nameRol = nameRolField.getText();
                Long codeModeAdmin = Long.parseLong(codeModeAdminField.getText());
                Long codeAp = Long.parseLong(codeApField.getText());
                Long codeUm = Long.parseLong(codeUmField.getText());
                Long codeLab = Long.parseLong(codeLabField.getText());

               
                updateMedicineUseCase.execute(id, proceedings, name, healthRegister, description, descriptionShort, nameRol, codeModeAdmin, codeAp, codeUm, codeLab);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeMedicine() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Customer ID: "));
            deleteMedicineUseCase.execute(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
