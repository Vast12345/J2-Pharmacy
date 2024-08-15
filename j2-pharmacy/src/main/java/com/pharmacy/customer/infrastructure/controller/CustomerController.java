package com.pharmacy.customer.infrastructure.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.customer.application.CreateCustomerUseCase;
import com.pharmacy.customer.application.DeleteCustomerUseCase;
import com.pharmacy.customer.application.FindCustomerUseCase;
import com.pharmacy.customer.application.UpdateCustomerUseCase;
import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;
import com.pharmacy.customer.infrastructure.repository.CustomerRepository;

public class CustomerController {
    CustomerService customerService;
    CreateCustomerUseCase createCustomerUseCase;
    FindCustomerUseCase findCustomerUseCase;
    UpdateCustomerUseCase updateCustomerUseCase;
    DeleteCustomerUseCase deleteCustomerUseCase;

    public CustomerController() {
        customerService = new CustomerRepository();
        createCustomerUseCase = new CreateCustomerUseCase(customerService);
        findCustomerUseCase = new FindCustomerUseCase(customerService);
        updateCustomerUseCase = new UpdateCustomerUseCase(customerService);
        deleteCustomerUseCase = new DeleteCustomerUseCase(customerService);
    }

    public void customerMenu() {
        String opciones = "1. Add Customer\n2. Search Customer\n3. Update Customer\n4. Delete Customer\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    searchCustomer();
                    break;
                case 3:
                    amendCustomer();
                    break;
                case 4:
                    removeCustomer();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addCustomer() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField lastNameField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JTextField birthdateField = new JTextField(10);
        JTextField lonField = new JTextField(10);
        JTextField latitudField = new JTextField(10);
        JTextField codeCityField = new JTextField(10);

        panel.add(new JLabel("Customer ID:"));
        panel.add(idField);
        panel.add(new JLabel("Customer Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Customer Last Name: "));
        panel.add(lastNameField);
        panel.add(new JLabel("Customer Email: "));
        panel.add(emailField);
        panel.add(new JLabel("Customer Birthdate (yyyy-MM-dd): "));
        panel.add(birthdateField);
        panel.add(new JLabel("Customer Lon: "));
        panel.add(lonField);
        panel.add(new JLabel("Customer Latitud: "));
        panel.add(latitudField);
        panel.add(new JLabel("Customer City Code: "));
        panel.add(codeCityField);
        


        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                LocalDate localDate = LocalDate.parse(birthdateField.getText());
                try {
                    String id = idField.getText();
                    String name = nameField.getText();
                    String lastName= lastNameField.getText();
                    String email = emailField.getText();
                    Date birthdate = Date.valueOf(localDate);
                    Float lon = Float.parseFloat(lonField.getText());
                    Float latitud = Float.parseFloat(latitudField.getText());
                    String codeCity = codeCityField.getText();
    
                    Customer customer = new Customer();
                    customer.setIdCustomer(id);
                    customer.setNameCustomer(name);
                    customer.setLastNameCustomer(lastName);
                    customer.setEmailCustomer(email);
                    customer.setBirthdate(birthdate);
                    customer.setLon(lon);
                    customer.setLatitud(latitud);
                    customer.setCodeCityCustomer(codeCity);
                    createCustomerUseCase.execute(customer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch(DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid Date Format");
            }
        }
    }

    public void searchCustomer() {
        try {
            String id = JOptionPane.showInputDialog(null, "Enter Customer ID: ");
            findCustomerUseCase.execute(id).ifPresentOrElse(foundCustomer -> {
                JOptionPane.showMessageDialog(null, foundCustomer.toString());
                foundCustomer.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendCustomer() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField lastNameField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JTextField birthdateField = new JTextField(10);
        JTextField lonField = new JTextField(10);
        JTextField latitudField = new JTextField(10);
        JTextField codeCityField = new JTextField(10);

        panel.add(new JLabel("Customer ID:"));
        panel.add(idField);
        panel.add(new JLabel("New Customer Name:"));
        panel.add(nameField);
        panel.add(new JLabel("New Customer Last Name: "));
        panel.add(lastNameField);
        panel.add(new JLabel("New Customer Email: "));
        panel.add(emailField);
        panel.add(new JLabel("New Customer Birthdate (yyy-MM-dd): "));
        panel.add(birthdateField);
        panel.add(new JLabel("New Customer Lon: "));
        panel.add(lonField);
        panel.add(new JLabel("New Customer Latitud: "));
        panel.add(latitudField);
        panel.add(new JLabel("New Customer City Code: "));
        panel.add(codeCityField);
        


        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            LocalDate localDate = LocalDate.parse(birthdateField.getText());
            try {
                try {
                    String id = idField.getText();
                    String name = nameField.getText();
                    String lastName= lastNameField.getText();
                    String email = emailField.getText();
                    Date birthdate = Date.valueOf(localDate);
                    Float lon = Float.parseFloat(lonField.getText());
                    Float latitud = Float.parseFloat(latitudField.getText());
                    String codeCity = codeCityField.getText();
    
                    updateCustomerUseCase.execute(id, name, lastName, email, birthdate, lon, latitud, codeCity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch(DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid Date Format");
            }

        }
    }

    public void removeCustomer() {
        try {
            String id = JOptionPane.showInputDialog(null, "Enter Customer ID: ");
            deleteCustomerUseCase.execute(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
