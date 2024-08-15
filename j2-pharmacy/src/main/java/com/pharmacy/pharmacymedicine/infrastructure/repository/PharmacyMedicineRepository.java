package com.pharmacy.pharmacymedicine.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.pharmacy.pharmacymedicine.domain.entity.PharmacyMedicine;
import com.pharmacy.pharmacymedicine.domain.service.PharmacyMedicineService;

public class PharmacyMedicineRepository implements PharmacyMedicineService{
    private Connection connection;

    public PharmacyMedicineRepository() {
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
    public void createPharmacyMedicine(PharmacyMedicine pharmacyMedicine) {
        String sql = "Insert into pharmacymedicine (idpharmacy, idmedicine, price) values (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, pharmacyMedicine.getIdPharmacy());
            statement.setLong(2, pharmacyMedicine.getIdMedicine());
            statement.setFloat(3, pharmacyMedicine.getPrice());
            statement.executeUpdate();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "No References in database.");
            e.printStackTrace();
        }
    }

    @Override
    public Optional<PharmacyMedicine> findPharmacyMedicine(Long idPharm, Long idMed) {
        String sql = "select * from pharmacymedicine where idpharmacy = ? and idmedicine = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, idPharm);
            statement.setLong(2, idMed);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    PharmacyMedicine pharmacyMedicine = new PharmacyMedicine(
                        rs.getLong("idpharmacy"),
                        rs.getLong("idmedicine"),
                        rs.getFloat("price")
                    );
                    return Optional.of(pharmacyMedicine);
                }
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Couldnt find Record");
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<PharmacyMedicine> updatePharmacyMedicine(Long idPharm, Long idMed, Float price) {
        String sql = "update pharmacymedicine set price = ? where idpharmacy = ? and idmedicine = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, price);
            statement.setLong(2, idPharm);
            statement.setLong(3, idMed);
            statement.executeUpdate();
            
           PharmacyMedicine pharmacyMedicine = new PharmacyMedicine (idPharm, idMed, price);
            return Optional.of(pharmacyMedicine);
        } catch(SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deletePharmacyMedicine(Long idPharm, Long idMed) {
        String sql = "delete from pharmacymedicine where idpharmacy = ? and idmedicine = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, idPharm);
            statement.setLong(2, idMed);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
