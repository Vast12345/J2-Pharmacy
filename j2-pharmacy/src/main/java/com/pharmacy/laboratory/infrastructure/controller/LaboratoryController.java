package com.pharmacy.laboratory.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.laboratory.application.CreateLaboratoryUseCase;
import com.pharmacy.laboratory.application.DeleteLaboratoryUseCase;
import com.pharmacy.laboratory.application.FindLaboratoryUseCase;
import com.pharmacy.laboratory.application.UpdateLaboratoryUseCase;
import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;
import com.pharmacy.laboratory.infrastructure.repository.LaboratoryRepository;

public class LaboratoryController {
    LaboratoryService laboratoryService;
    CreateLaboratoryUseCase createLaboratoryUseCase;
    FindLaboratoryUseCase findLaboratoryUseCase;
    UpdateLaboratoryUseCase updateLaboratoryUseCase;
    DeleteLaboratoryUseCase deleteLaboratoryUseCase;

    public LaboratoryController() {
        laboratoryService = new LaboratoryRepository();
        createLaboratoryUseCase = new CreateLaboratoryUseCase(laboratoryService);
        findLaboratoryUseCase = new FindLaboratoryUseCase(laboratoryService);
        deleteLaboratoryUseCase = new DeleteLaboratoryUseCase(laboratoryService);
    }

    public void laboratoryMenu() {
        String opciones = "1. Add Laboratory\n2. Search Laboratory\n3. Update Laboratory\n4. Delete Laboratory\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addLaboratory();
                    break;
                case 2:
                    searchLaboratory();
                    break;
                case 3:
                    amendLaboratory();
                    break;
                case 4:
                    removeLaboratory();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addLaboratory() {
        String name = JOptionPane.showInputDialog(null, "Add Name");
        String code = JOptionPane.showInputDialog(null, "Add City Code");
        Laboratory lab = new Laboratory();
        lab.setNameLab(name);
        lab.setCodeCity(code);
        createLaboratoryUseCase.execute(lab);
        System.out.println("Lab created successfully");
    }

    public void searchLaboratory() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter City ID: "));
            findLaboratoryUseCase.execute(id).ifPresentOrElse(foundLaboratory -> {
                JOptionPane.showMessageDialog(null, foundLaboratory.toString());
                foundLaboratory.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendLaboratory() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField codeField = new JTextField(10);

        panel.add(new JLabel("Lab ID:"));
        panel.add(idField);
        panel.add(new JLabel("City Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Region Code: "));
        panel.add(codeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Long id = Long.parseLong(idField.getText());
                String code = codeField.getText();
                String name= nameField.getText();

                updateLaboratoryUseCase.execute(id, name, code).ifPresentOrElse(updatedLaboratory -> {
                    JOptionPane.showMessageDialog(null, updatedLaboratory.toString());
                }, () -> {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }

    public void removeLaboratory() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Lab ID: "));
            deleteLaboratoryUseCase.execute(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
