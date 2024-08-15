package com.pharmacy.laboratory.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;

public class LaboratoryRepository implements LaboratoryService{
    private Connection connection;

    public LaboratoryRepository() {
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
    public void createLaboratory(Laboratory laboratory) {
        String sql = "Insert into laboratory (id, namelab, codecityreg) values (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, laboratory.getId());
            statement.setString(2, laboratory.getNameLab());
            statement.setString(3, laboratory.getCodeCity());
            statement.executeUpdate();
            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    laboratory.setId(generatedKeys.getLong(1));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Laboratory> findLaboratory(Long id) {
        String sql = "select * from laboratory where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Laboratory laboratory = new Laboratory(
                        rs.getLong("id"),
                        rs.getString("namelab"),
                        rs.getString("codecityreg")
                    );
                    return Optional.of(laboratory);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Laboratory> updateLaboratory(Long id, String name, String code) {
        String sql = "update laboratory set namelab = ?, codecityreg = ? where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, code);
            statement.setLong(3, id);
            statement.executeUpdate();
            
           Laboratory laboratory = new Laboratory (id, name, code);
            return Optional.of(laboratory);
        } catch(SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteLaboratory(Long id) {
        String sql = "delete from laboratory where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    
}
