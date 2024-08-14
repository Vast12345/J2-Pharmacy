package com.pharmacy.city.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.city.application.CreateCityUseCase;
import com.pharmacy.city.application.DeleteCityUseCase;
import com.pharmacy.city.application.FindCityUseCase;
import com.pharmacy.city.application.UpdateCityUseCase;
import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;
import com.pharmacy.city.infrastructure.repository.CityRepository;

public class CityController {
    CityService cityService;
    CreateCityUseCase createCityUseCase;
    FindCityUseCase findCityUseCase;
    UpdateCityUseCase updateCityUseCase;
    DeleteCityUseCase deleteCityUseCase;

    public CityController() {
        cityService = new CityRepository();
        createCityUseCase = new CreateCityUseCase(cityService);
        findCityUseCase = new FindCityUseCase(cityService);
        updateCityUseCase = new UpdateCityUseCase(cityService);
        deleteCityUseCase = new DeleteCityUseCase(cityService);
    }

    public void cityMenu() {
        String opciones = "1. Add City\n2. Search City\n3. Update City\n4. Delete City\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addCity();
                    break;
                case 2:
                    searchCity();
                    break;
                case 3:
                    amendCity();
                    break;
                case 4:
                    removeCity();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addCity() {
        String id = JOptionPane.showInputDialog(null, "Add City Code");
        String name = JOptionPane.showInputDialog(null, "Add Name");
        String code = JOptionPane.showInputDialog(null, "Add egion Code");
        City city = new City();
        city.setCodeCity(id);
        city.setNameCity(name);
        city.setCodeReg(code);
        createCityUseCase.execute(city);
        System.out.println("Region created successfully");
    }

    public void searchCity() {
        try {
            String id = JOptionPane.showInputDialog(null, "Enter City ID: ");
            findCityUseCase.execute(id).ifPresentOrElse(foundCity -> {
                JOptionPane.showMessageDialog(null, foundCity.toString());
                foundCity.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendCity() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField codeField = new JTextField(10);

        panel.add(new JLabel("City ID:"));
        panel.add(idField);
        panel.add(new JLabel("City Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Region Code: "));
        panel.add(codeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText();
                String code = codeField.getText();
                String name= nameField.getText();

                updateCityUseCase.execute(id, name, code).ifPresentOrElse(updatedCity -> {
                    JOptionPane.showMessageDialog(null, updatedCity.toString());
                }, () -> {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeCity() {
        try {
            String id = JOptionPane.showInputDialog(null, "Enter City ID: ");
            deleteCityUseCase.execute(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
