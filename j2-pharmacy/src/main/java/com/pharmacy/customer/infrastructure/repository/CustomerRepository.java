package com.pharmacy.customer.infrastructure.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class CustomerRepository implements CustomerService{
    private Connection connection;

    public CustomerRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCustomer(Customer customer) {
        String sql = "Insert into customer (idcustomer, namecustomer, lastnamecustomer, emailcustomer, birthdate, lon, latidud, codecitycustomer) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getIdCustomer());
            statement.setString(2, customer.getNameCustomer());
            statement.setString(3, customer.getLastNameCustomer());
            statement.setString(4, customer.getEmailCustomer());
            statement.setDate(5, customer.getBirthdate());
            statement.setFloat(6, customer.getLon());
            statement.setFloat(7, customer.getLatitud());
            statement.setString(8, customer.getCodeCityCustomer());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error with Database");
        }
    }

    @Override
    public Optional<Customer> findCustomer(String id) {
        String sql = "select * from customer where idcustomer = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer(
                        rs.getString("idcustomer"),
                        rs.getString("namecustomer"),
                        rs.getString("lastnamecustomer"),
                        rs.getString("emailcustomer"),
                        rs.getDate("birthdate"),
                        rs.getFloat("lon"),
                        rs.getFloat("latidud"),
                        rs.getString("codecitycustomer")
                    );
                    return Optional.of(customer);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Customer> updateCustomer(String id, String name, String lastName, String email, Date birthdate, float lon, float latitud, String codeCityCustomer) {
        String sql = "update customer set namecustomer = ?, lastnamecustomer = ?, emailcustomer = ?, birthdate = ?, lon = ?, latidud = ?, codecitycustomer = ? where idcustomer = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setDate(4, birthdate);
            statement.setFloat(5, lon);
            statement.setFloat(6, latitud);
            statement.setString(7, codeCityCustomer);
            statement.setString(8, id);
            statement.executeUpdate();
            
            Customer customer = new Customer (id, name, lastName, email, birthdate, lon, latitud, codeCityCustomer);
            return Optional.of(customer);
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error with Database");
            return Optional.empty();
        }
    }

    @Override
    public void deleteCustomer(String id) {
        String sql = "delete from customer where idcustomer = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
