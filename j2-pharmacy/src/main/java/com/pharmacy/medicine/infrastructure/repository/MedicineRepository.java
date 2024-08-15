package com.pharmacy.medicine.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class MedicineRepository implements MedicineService{
    private Connection connection;

    public MedicineRepository() {
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
    public void createMedicine(Medicine medicine) {
        String sql = "Insert into medicine (id, proceedings, namemedicine, healthregister, description, descriptionshort, namerol, codemodeadmin, codeap, codeum, codelab) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(2, medicine.getProceedings());
            statement.setString(3, medicine.getNameMedicine());
            statement.setString(4, medicine.getHealthRegister());
            statement.setString(5, medicine.getDescription());
            statement.setString(6, medicine.getDescriptionShort());
            statement.setString(7, medicine.getNameRol());
            statement.setLong(8, medicine.getCodeModeAdmin());
            statement.setLong(9, medicine.getCodeAp());
            statement.setLong(10, medicine.getCodeUm());
            statement.setLong(11, medicine.getCodeLab());
            statement.executeUpdate();

            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    medicine.setId(generatedKeys.getLong(1));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error with Database");
        }
    }

    @Override
    public Optional<Medicine> findMedicine(Long id) {
        String sql = "select * from medicine where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Medicine medicine = new Medicine(
                        rs.getLong("id"),
                        rs.getString("proceedings"),
                        rs.getString("namemedicine"),
                        rs.getString("healthregister"),
                        rs.getString("description"),
                        rs.getString("descriptionshort"),
                        rs.getString("namerol"),
                        rs.getLong("codemodeadmin"),
                        rs.getLong("codeap"),
                        rs.getLong("codeum"),
                        rs.getLong("codelab")
                    );
                    return Optional.of(medicine);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Medicine> updateMedicine(Long id, String proceedings, String nameMedicine, String healthRegister, String description, String descriptionShort, String nameRol, Long codeModeAdmin, Long codeAp, Long codeUm, Long codeLab) {
        String sql = "update customer set proceedings = ?, namemedicine = ?, healthregister = ?, description = ?, descriptionshort = ?, codemodeadmin = ?, codeap = ?, codeum = ?, codelab = ? where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proceedings);
            statement.setString(2, nameMedicine);
            statement.setString(3, healthRegister);
            statement.setString(4, description);
            statement.setString(5, descriptionShort);
            statement.setString(6, nameRol);
            statement.setLong(7, codeModeAdmin);
            statement.setLong(8, codeAp);
            statement.setLong(9, codeUm);
            statement.setLong(10, codeLab);
            statement.setLong(11, id);
            statement.executeUpdate();
            
            Medicine medicine = new Medicine (id, proceedings, nameMedicine, healthRegister, description, descriptionShort, nameRol, codeModeAdmin, codeAp, codeUm, codeLab);
            return Optional.of(medicine);
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error with Database");
            return Optional.empty();
        }
    }

    @Override
    public void deleteMedicine(Long id) {
        String sql = "delete from medicine where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
