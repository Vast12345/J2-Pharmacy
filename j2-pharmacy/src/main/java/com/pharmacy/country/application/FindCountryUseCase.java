package com.pharmacy.country.application;

import java.util.Optional;

import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.domain.service.CountryService;

public class FindCountryUseCase {
    private final CountryService countryService;

    public FindCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public Optional<Country> execute(String id) {
        return countryService.findCountry(id);
    }
}
