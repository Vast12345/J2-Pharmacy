package com.pharmacy.country.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.domain.service.CountryService;

public class CountryRepository implements CountryService{
    private Connection connection;

    public CountryRepository() {
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
    public void createCountry(Country country) {
        String sql = "Insert into country (codecountry, namecountry) values (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, country.getCodeCountry());
            statement.setString(2, country.getNameCountry());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Country> findCountry(String id) {
        String sql = "select * from country where codecountry = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Country country = new Country(
                        rs.getString("codecountry"),
                        rs.getString("namecountry")
                    );
                    return Optional.of(country);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> updateCountry(String id, String value) {
        String sql = "update country set namecountry = ? where codecountry = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(2, id);
            statement.setString(1, value);
            statement.executeUpdate();
            
           Country country  = new Country (id, value);
            return Optional.of(country);
        } catch(SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteCountry(String id) {
        String sql = "delete from country where codecountry = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


}
