package com.pharmacy.city.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;

public class CityRepository implements CityService{
    private Connection connection;


    
    public CityRepository() {
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
    public void createCity(City city) {
        String sql = "Insert into city (codecity, namecity, codereg) values (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, city.getCodeCity());
            statement.setString(2, city.getNameCity());
            statement.setString(3, city.getCodeReg());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<City> findCity(String id) {
        String sql = "select * from city where codecity = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    City city = new City(
                        rs.getString("codereg"),
                        rs.getString("namereg"),
                        rs.getString("codecountry")
                    );
                    return Optional.of(city);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<City> updateCity(String id, String name, String code) {
        String sql = "update city set namecity = ?, codereg = ? where codecity = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, code);
            statement.setString(3, id);
            statement.executeUpdate();
            
           City city = new City (id, name, code);
            return Optional.of(city);
        } catch(SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteCity(String id) {
        String sql = "delete from city where codecity = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
