package com.pharmacy.city.application;

import java.util.Optional;

import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;

public class FindCityUseCase {
    private final CityService cityService;

    public FindCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute(String id) {
        return cityService.findCity(id);
    }
}
