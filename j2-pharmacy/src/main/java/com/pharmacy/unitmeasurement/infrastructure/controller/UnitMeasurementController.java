package com.pharmacy.unitmeasurement.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.unitmeasurement.application.CreateUnitMeasurementUseCase;
import com.pharmacy.unitmeasurement.application.DeleteUnitMeasurementUseCase;
import com.pharmacy.unitmeasurement.application.FindUnitMeasurementUseCase;
import com.pharmacy.unitmeasurement.application.UpdateUnitMeasurementUseCase;
import com.pharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.pharmacy.unitmeasurement.domain.service.UnitMeasurementService;
import com.pharmacy.unitmeasurement.infrastructure.repository.UnitMeasurementRepository;

public class UnitMeasurementController {
    UnitMeasurementService unitMeasurementService;
    CreateUnitMeasurementUseCase createUnitMeasurementUseCase;
    FindUnitMeasurementUseCase findUnitMeasurementUseCase;
    UpdateUnitMeasurementUseCase updateUnitMeasurementUseCase;
    DeleteUnitMeasurementUseCase deleteUnitMeasurementUseCase;

    public UnitMeasurementController() {
        unitMeasurementService = new UnitMeasurementRepository();
        createUnitMeasurementUseCase = new CreateUnitMeasurementUseCase(unitMeasurementService);
        findUnitMeasurementUseCase = new FindUnitMeasurementUseCase(unitMeasurementService);
        updateUnitMeasurementUseCase = new UpdateUnitMeasurementUseCase(unitMeasurementService);
        deleteUnitMeasurementUseCase = new DeleteUnitMeasurementUseCase(unitMeasurementService);
    }

    public void unitMeasurementMenu() {
        String opciones = "1. Add Unit Measurement\n2. Search Unit Measurement\n3. Update Unit Measurement\n4. Delete Unit Measurement\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addUnitMeasurement();
                    break;
                case 2:
                    searchUnitMeasurement();
                    break;
                case 3:
                    amendUnitMeasurement();
                    break;
                case 4:
                    removeUnitMeasurement();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addUnitMeasurement() {
        String name = JOptionPane.showInputDialog(null, "Add Name");
        UnitMeasurement unitMeasurement = new UnitMeasurement();
        unitMeasurement.setNameUm(name);
        createUnitMeasurementUseCase.execute(unitMeasurement);
        System.out.println("Unit Measurement created successfully");
    }

    public void searchUnitMeasurement() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter UM ID: "));
            findUnitMeasurementUseCase.execute(id).ifPresentOrElse(foundUm -> {
                JOptionPane.showMessageDialog(null, foundUm.toString());
                foundUm.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendUnitMeasurement() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);

        panel.add(new JLabel("UM ID:"));
        panel.add(idField);
        panel.add(new JLabel("UM Name:"));
        panel.add(nameField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Long id = Long.parseLong(idField.getText());
                String name= nameField.getText();

                updateUnitMeasurementUseCase.execute(id, name).ifPresentOrElse(updatedUm -> {
                    JOptionPane.showMessageDialog(null, updatedUm.toString());
                }, () -> {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
    }

    public void removeUnitMeasurement() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter UM ID: "));
            deleteUnitMeasurementUseCase.execute(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
