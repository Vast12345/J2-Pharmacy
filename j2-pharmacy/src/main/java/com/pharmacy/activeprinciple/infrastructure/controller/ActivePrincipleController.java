package com.pharmacy.activeprinciple.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.activeprinciple.application.CreateActivePrincipleUseCase;
import com.pharmacy.activeprinciple.application.DeleteActivePrincipleUseCase;
import com.pharmacy.activeprinciple.application.FindActivePrincipleUseCase;
import com.pharmacy.activeprinciple.application.UpdateActivePrincipleUseCase;
import com.pharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.pharmacy.activeprinciple.domain.service.ActivePrincipleService;
import com.pharmacy.activeprinciple.infrastructure.repository.ActivePrincipleRepository;

public class ActivePrincipleController {
    ActivePrincipleService activePrincipleService;
    CreateActivePrincipleUseCase createActivePrincipleUseCase;
    FindActivePrincipleUseCase findActivePrincipleUseCase;
    UpdateActivePrincipleUseCase updateActivePrincipleUseCase;
    DeleteActivePrincipleUseCase deleteActivePrincipleUseCase;

    public ActivePrincipleController() {
        activePrincipleService = new ActivePrincipleRepository();
        createActivePrincipleUseCase = new CreateActivePrincipleUseCase(activePrincipleService);
        findActivePrincipleUseCase = new FindActivePrincipleUseCase(activePrincipleService);
        updateActivePrincipleUseCase = new UpdateActivePrincipleUseCase(activePrincipleService);
        deleteActivePrincipleUseCase = new DeleteActivePrincipleUseCase(activePrincipleService);
    }

    public void activePrincipleMenu() {
        String opciones = "1. Add Principle\n2. Search Principle\n3. Update Principle\n4. Delete Principle\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addActivePrinciple();
                    break;
                case 2:
                    searchActivePrinciple();
                    break;
                case 3:
                    amendActivePrinciple();
                    break;
                case 4:
                    removeActivePrinciple();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addActivePrinciple() {
        String name = JOptionPane.showInputDialog(null, "Add Name");
        ActivePrinciple activePrinciple = new ActivePrinciple();
        activePrinciple.setNameap(name);
        createActivePrincipleUseCase.execute(activePrinciple);
        System.out.println("Principle created successfully");
    }

    public void searchActivePrinciple() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Principle ID: "));
            findActivePrincipleUseCase.execute(id).ifPresentOrElse(foundPrinciple -> {
                JOptionPane.showMessageDialog(null, foundPrinciple.toString());
                foundPrinciple.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendActivePrinciple() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);

        panel.add(new JLabel("Principle ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Long id = Long.parseLong(idField.getText());
                String name= nameField.getText();

                updateActivePrincipleUseCase.execute(id, name).ifPresentOrElse(updatedPrinciple -> {
                    JOptionPane.showMessageDialog(null, updatedPrinciple.toString());
                }, () -> {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeActivePrinciple() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Principle ID: "));
            deleteActivePrincipleUseCase.execute(id);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
