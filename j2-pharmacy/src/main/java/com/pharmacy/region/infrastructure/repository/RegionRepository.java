package com.pharmacy.region.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.region.domain.entity.Region;
import com.pharmacy.region.domain.service.RegionService;

public class RegionRepository implements RegionService{
    private Connection connection;

    public RegionRepository() {
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
    public void createRegion(Region region) {
        String sql = "Insert into region (codereg, namereg, codecountry) values (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, region.getCodeReg());
            statement.setString(2, region.getNameReg());
            statement.setString(3, region.getCodeCountry());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Region> findRegion(String id) {
        String sql = "select * from region where codereg = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Region region = new Region(
                        rs.getString("codereg"),
                        rs.getString("namereg"),
                        rs.getString("codecountry")
                    );
                    return Optional.of(region);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Region> updateRegion(String id, String name, String code) {
        String sql = "update region set namereg = ?, codecountry = ? where codecountry = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, code);
            statement.setString(3, id);
            statement.executeUpdate();
            
           Region region  = new Region (id, name, code);
            return Optional.of(region);
        } catch(SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteRegion(String id) {
        String sql = "delete from region where codereg = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


}
