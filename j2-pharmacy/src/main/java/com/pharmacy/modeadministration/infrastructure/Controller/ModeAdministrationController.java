package com.pharmacy.modeadministration.infrastructure.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.modeadministration.application.CreateModeAdministrationUseCase;
import com.pharmacy.modeadministration.application.DeleteModeAdministrationUseCase;
import com.pharmacy.modeadministration.application.FindModeAdministrationUseCase;
import com.pharmacy.modeadministration.application.UpdateModeAdministrationUseCase;
import com.pharmacy.modeadministration.domain.entity.ModeAdministration;
import com.pharmacy.modeadministration.domain.service.ModeAdministrationService;
import com.pharmacy.modeadministration.infrastructure.repository.ModeAdministrationRepository;

public class ModeAdministrationController {
    ModeAdministrationService modeAdministrationService;
    CreateModeAdministrationUseCase createModeAdministrationUseCase;
    FindModeAdministrationUseCase findModeAdministrationUseCase;
    UpdateModeAdministrationUseCase updateModeAdministrationUseCase;
    DeleteModeAdministrationUseCase deleteModeAdministrationUseCase;

    public ModeAdministrationController() {
        modeAdministrationService = new ModeAdministrationRepository();
        createModeAdministrationUseCase = new CreateModeAdministrationUseCase(modeAdministrationService);
        findModeAdministrationUseCase = new FindModeAdministrationUseCase(modeAdministrationService);
        updateModeAdministrationUseCase = new UpdateModeAdministrationUseCase(modeAdministrationService);
        deleteModeAdministrationUseCase = new DeleteModeAdministrationUseCase(modeAdministrationService);
    }

    public void modeAdministrationMenu() {
        String opciones = "1. Add Mode\n2. Search Mode\n3. Update Mode\n4. Delete Mode\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addModeAdministration();
                    break;
                case 2:
                    searchModeAdministration();
                    break;
                case 3:
                    amendModeAdministration();
                    break;
                case 4:
                    removeModeAdministration();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addModeAdministration() {
        String descriptionMode = JOptionPane.showInputDialog(null, "Add Description");
        ModeAdministration modeAdministration = new ModeAdministration();
        modeAdministration.setDescriptionmode(descriptionMode);
        createModeAdministrationUseCase.execute(modeAdministration);
        System.out.println("Mode created successfully");
    }

    public void searchModeAdministration() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Mode ID: "));
            findModeAdministrationUseCase.execute(id).ifPresentOrElse(foundMode -> {
                JOptionPane.showMessageDialog(null, foundMode.toString());
                foundMode.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendModeAdministration() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField descriptionField = new JTextField(10);

        panel.add(new JLabel("Mode ID:"));
        panel.add(idField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Long id = Long.parseLong(idField.getText());
                String description = descriptionField.getText();

                updateModeAdministrationUseCase.execute(id, description).ifPresentOrElse(updatedMode -> {
                    JOptionPane.showMessageDialog(null, updatedMode.toString());
                }, () -> {
                });
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeModeAdministration() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Mode ID: "));
            deleteModeAdministrationUseCase.execute(id);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

