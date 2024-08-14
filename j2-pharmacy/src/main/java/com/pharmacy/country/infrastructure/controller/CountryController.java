package com.pharmacy.country.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.country.application.CreateCountryUseCase;
import com.pharmacy.country.application.DeleteCountryUseCase;
import com.pharmacy.country.application.FindCountryUseCase;
import com.pharmacy.country.application.UpdateCountryUseCase;
import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.domain.service.CountryService;
import com.pharmacy.country.infrastructure.repository.CountryRepository;

public class CountryController {
    CountryService countryService;
    CreateCountryUseCase createCountryUseCase;
    FindCountryUseCase findCountryUseCase;
    UpdateCountryUseCase updateCountryUseCase;
    DeleteCountryUseCase deleteCountryUseCase;

    public CountryController() {
        countryService = new CountryRepository();
        createCountryUseCase = new CreateCountryUseCase(countryService);
        findCountryUseCase = new FindCountryUseCase(countryService);
        updateCountryUseCase = new UpdateCountryUseCase(countryService);
        deleteCountryUseCase = new DeleteCountryUseCase(countryService);
    }

    public void countryMenu() {
        String opciones = "1. Add Country\n2. Search Country\n3. Update Country\n4. Delete Country\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    searchCountry();
                    break;
                case 3:
                    amendCountry();
                    break;
                case 4:
                    removeCountry();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addCountry() {
        String code = JOptionPane.showInputDialog(null, "Add Code");
        String name = JOptionPane.showInputDialog(null, "Add Name");
        Country country = new Country();
        country.setCodeCountry(code);
        country.setNameCountry(name);
        createCountryUseCase.execute(country);
        System.out.println("Country created successfully");
    }

    public void searchCountry() {
        try {
            String id = JOptionPane.showInputDialog(null, "Enter Principle ID: ");
            findCountryUseCase.execute(id).ifPresentOrElse(foundCountry -> {
                JOptionPane.showMessageDialog(null, foundCountry.toString());
                foundCountry.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendCountry() {
        JPanel panel = new JPanel();

        JTextField codeField = new JTextField(10);
        JTextField nameField = new JTextField(10);

        panel.add(new JLabel("Country Code:"));
        panel.add(codeField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String code = codeField.getText();
                String name= nameField.getText();

                updateCountryUseCase.execute(code, name).ifPresentOrElse(updatedCountry -> {
                    JOptionPane.showMessageDialog(null, updatedCountry.toString());
                }, () -> {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeCountry() {
        try {
            String code = JOptionPane.showInputDialog(null, "Enter Country Code: ");
            deleteCountryUseCase.execute(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
