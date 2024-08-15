package com.pharmacy.pharmacy.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.pharmacy.application.CreatePharmacyUseCase;
import com.pharmacy.pharmacy.application.DeletePharamcyUseCase;
import com.pharmacy.pharmacy.application.FindPharmacyUseCase;
import com.pharmacy.pharmacy.application.UpdatePharmacyUseCase;
import com.pharmacy.pharmacy.domain.entity.Pharmacy;
import com.pharmacy.pharmacy.domain.service.PharmacyService;
import com.pharmacy.pharmacy.infrastructure.repository.PharmacyRepository;

public class PharmacyController {
    PharmacyService pharmacyService;
    CreatePharmacyUseCase createPharmacyUseCase;
    FindPharmacyUseCase findPharmacyUseCase;
    UpdatePharmacyUseCase updatePharmacyUseCase;
    DeletePharamcyUseCase deletePharmacyUseCase;

    public PharmacyController() {
        pharmacyService = new PharmacyRepository();
        createPharmacyUseCase = new CreatePharmacyUseCase(pharmacyService);
        findPharmacyUseCase = new FindPharmacyUseCase(pharmacyService);
        updatePharmacyUseCase = new UpdatePharmacyUseCase(pharmacyService);
        deletePharmacyUseCase = new DeletePharamcyUseCase(pharmacyService);
    }

    public void pharmacyMenu() {
        String opciones = "1. Add Pharmacy\n2. Search Pharmacy\n3. Update Pharmacy\n4. Delete Pharmacy\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addPharmacy();
                    break;
                case 2:
                    searchPharmacy();
                    break;
                case 3:
                    amendPharmacy();
                    break;
                case 4:
                    removePharmacy();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addPharmacy() {
        JPanel panel = new JPanel();

        JTextField nameField = new JTextField(10);
        JTextField addressField = new JTextField(10);
        JTextField iongField = new JTextField(10);
        JTextField latField = new JTextField(10);
        JTextField codeField = new JTextField(10);
        JTextField logoField = new JTextField(10);

        panel.add(new JLabel("Customer Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Customer Last Name: "));
        panel.add(addressField);
        panel.add(new JLabel("Customer Email: "));
        panel.add(iongField);
        panel.add(new JLabel("Customer Birthdate (yyyy-MM-dd): "));
        panel.add(latField);
        panel.add(new JLabel("Customer Lon: "));
        panel.add(codeField);
        panel.add(new JLabel("Customer Latitud: "));
        panel.add(logoField);
        


        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                String address= addressField.getText();
                String code = codeField.getText();
                String logo = logoField.getText();
                Float iong = Float.parseFloat(iongField.getText());
                Float lat = Float.parseFloat(latField.getText());

                Pharmacy pharmacy = new Pharmacy();
                pharmacy.setNamePharmacy(name);
                pharmacy.setAddressPharmacy(address);
                pharmacy.setIong(iong);
                pharmacy.setLatPharmacy(lat);
                pharmacy.setCodeCityPharm(code);
                pharmacy.setLogoPharmacy(logo);
                createPharmacyUseCase.execute(pharmacy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void searchPharmacy() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Pharmacy ID: "));
            findPharmacyUseCase.execute(id).ifPresentOrElse(foundPharmacy -> {
                JOptionPane.showMessageDialog(null, foundPharmacy.toString());
                foundPharmacy.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendPharmacy() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField addressField = new JTextField(10);
        JTextField iongField = new JTextField(10);
        JTextField latField = new JTextField(10);
        JTextField codeField = new JTextField(10);
        JTextField logoField = new JTextField(10);

        panel.add(new JLabel("Pharmacy ID:"));
        panel.add(idField);
        panel.add(new JLabel("New Pharmacy Name:"));
        panel.add(nameField);
        panel.add(new JLabel("New Pharmacy Address: "));
        panel.add(addressField);
        panel.add(new JLabel("New Pharmacy Iong: "));
        panel.add(iongField);
        panel.add(new JLabel("New Pharmacy Lat: "));
        panel.add(latField);
        panel.add(new JLabel("New Pharmacy City Code: "));
        panel.add(codeField);
        panel.add(new JLabel("New Pharmacy Logo: "));
        panel.add(logoField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Long id = Long.parseLong(idField.getText());
                String name = nameField.getText();
                String address= addressField.getText();
                String code = codeField.getText();
                String logo = logoField.getText();
                Float iong = Float.parseFloat(iongField.getText());
                Float lat = Float.parseFloat(latField.getText());

                updatePharmacyUseCase.execute(id, name, address, iong, lat, code, logo);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void removePharmacy() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Pharmacy ID: "));
            deletePharmacyUseCase.execute(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
