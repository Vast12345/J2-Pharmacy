package com.pharmacy.city.domain.service;

import java.util.Optional;

import com.pharmacy.city.domain.entity.City;

public interface CityService {
    void createCity(City city);
    Optional<City> findCity(String id);
    Optional<City> updateCity(String id, String name, String code);
    void deleteCity(String id);
}
