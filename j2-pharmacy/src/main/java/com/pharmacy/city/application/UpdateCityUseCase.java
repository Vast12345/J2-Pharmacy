package com.pharmacy.city.application;

import java.util.Optional;

import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;

public class UpdateCityUseCase {
    private final CityService cityService;

    public UpdateCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute(String id, String name, String code) {
        return cityService.updateCity(id, name, code);
    }
}
