package com.pharmacy.pharmacy.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.pharmacy.pharmacy.domain.entity.Pharmacy;
import com.pharmacy.pharmacy.domain.service.PharmacyService;

public class PharmacyRepository implements PharmacyService{
    private Connection connection;

    public PharmacyRepository() {
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
    public void createPharmacy(Pharmacy pharmacy) {
        String sql = "Insert into pharmacy (namepharmacy, addresspharmacy, iong, latpharmacy, codecitypharm, logopharmacy) values (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(2,pharmacy.getNamePharmacy());
            statement.setString(3,pharmacy.getAddressPharmacy());
            statement.setFloat(4,pharmacy.getIong());
            statement.setFloat(5,pharmacy.getLatPharmacy());
            statement.setString(6,pharmacy.getCodeCityPharm());
            statement.setString(7,pharmacy.getLogoPharmacy());
            statement.executeUpdate();

            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    pharmacy.setIdPharmacy(generatedKeys.getLong(1));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error with Database");
        }
    }

    @Override
    public Optional<Pharmacy> findPharmacy(Long id) {
        String sql = "select * from pharmacy where idpharmacy = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Pharmacy pharmacy = new Pharmacy(
                        rs.getLong("idpharmacy"),
                        rs.getString("namepharmacy"),
                        rs.getString("addresspharmacy"),
                        rs.getLong("iong"),
                        rs.getLong("latpharmacy"),
                        rs.getString("codecitypharm"),
                        rs.getString("logopharmacy")
                    );
                    return Optional.of(pharmacy);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pharmacy> updatePharmacy(Long id, String name, String address, float iong, float lat, String code,
            String logo) {
        String sql = "update pharmacy set namepharmacy = ?, addresspharmacy = ?, iong = ?, latpharmacy = ?, codecitypharm = ?, logopharmacy = ? where idpharmacy = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setFloat(3, iong);
            statement.setFloat(4, lat);
            statement.setString(5, code);
            statement.setString(6, logo);
            statement.setLong(7, id);
            statement.executeUpdate();
            
            Pharmacy pharmacy = new Pharmacy (id, name, address, iong, lat, code, logo);
            return Optional.of(pharmacy);
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error with Database");
            return Optional.empty();
        }
    }

    @Override
    public void deletePharmacy(Long id) {
        String sql = "delete from pharmacy where idpharmacy = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }    
}
