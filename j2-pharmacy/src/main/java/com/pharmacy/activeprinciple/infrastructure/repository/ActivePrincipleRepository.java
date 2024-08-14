package com.pharmacy.activeprinciple.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.pharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class ActivePrincipleRepository implements ActivePrincipleService {
    private Connection connection;

    public ActivePrincipleRepository() {
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
    public void createActivePrinciple(ActivePrinciple activePrinciple) {
        String sql = "Insert into activeprinciple (nameap) values (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, 
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, activePrinciple.getNameap());
            statement.executeUpdate();

            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    activePrinciple.setIdap(generatedKeys.getLong(1));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ActivePrinciple> findActivePrinciple(Long id) {
        String sql = "select * from activeprinciple where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    ActivePrinciple activePrinciple = new ActivePrinciple(
                        rs.getLong("id"),
                        rs.getString("descriptionmode")
                    );
                    return Optional.of(activePrinciple);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<ActivePrinciple> updateActivePrinciple(Long id, String value) {
        String sql = "update activeprinciple set nameap = ? where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(2, id);
            statement.setString(1, value);
            statement.executeUpdate();
            
            ActivePrinciple activePrinciple = new ActivePrinciple(id, value);
            return Optional.of(activePrinciple);
        } catch(SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteActivePrinciple(Long id) {
        String sql = "delete from activeprinciple where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
