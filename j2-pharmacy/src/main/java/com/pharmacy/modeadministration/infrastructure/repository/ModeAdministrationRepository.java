package com.pharmacy.modeadministration.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.pharmacy.modeadministration.domain.entity.ModeAdministration;
import com.pharmacy.modeadministration.domain.service.ModeAdministrationService;

public class ModeAdministrationRepository implements ModeAdministrationService{
    private Connection connection;
    
    public ModeAdministrationRepository() {
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
    public void createModeAdministration(ModeAdministration modeAdministration) {
        String sql = "Insert into modeadministration (descriptionmode) values (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, 
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, modeAdministration.getDescriptionmode());
            statement.executeUpdate();

            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    modeAdministration.setId(generatedKeys.getLong(1));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ModeAdministration> findModeAdminstration(Long id) {
        String sql = "select * from modeadministration where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    ModeAdministration modeAdministration = new ModeAdministration(
                        rs.getLong("id"),
                        rs.getString("descriptionmode")
                    );
                    return Optional.of(modeAdministration);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<ModeAdministration> updateModeAdministration(Long id, String value) {
        String sql = "update modeadministration set descriptionmode = ? where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(2, id);
            statement.setString(1, value);
            int rows = statement.executeUpdate();
            
            if (rows > 0) {
                ModeAdministration modeAdministration = new ModeAdministration(id, value);
                return Optional.of(modeAdministration);
            } else {
                JOptionPane.showMessageDialog(null, "Error in update");
                return Optional.empty();
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteModeAdministration(Long id) {
        String sql = "delete from modeadministration where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
