package com.pharmacy.unitmeasurement.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.pharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class UnitMeasurementRepository implements UnitMeasurementService{
    private Connection connection;

    public UnitMeasurementRepository() {
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
    public void createUnitMeasurement(UnitMeasurement unitMeasurement) {
        String sql = "Insert into unitmeasurement (id, nameum) values (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, unitMeasurement.getIdUm());
            statement.setString(2, unitMeasurement.getNameUm());
            statement.executeUpdate();
            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    unitMeasurement.setIdUm(generatedKeys.getLong(1));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<UnitMeasurement> findUnitMeasurement(Long id) {
        String sql = "select * from unitmeasurement where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    UnitMeasurement unitMeasurement = new UnitMeasurement(
                        rs.getLong("idum"),
                        rs.getString("nameum")
                    );
                    return Optional.of(unitMeasurement);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<UnitMeasurement> updateUnitMeasurement(Long id, String name) {
        String sql = "update unitmeasurement set nameum = ? where idum = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setLong(3, id);
            statement.executeUpdate();
            
           UnitMeasurement unitMeasurement = new UnitMeasurement (id, name);
            return Optional.of(unitMeasurement);
        } catch(SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteUnitMeasurement(Long id) {
        String sql = "delete from laboratory where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
