package com.pharmacy.country.application;

import java.util.Optional;

import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.domain.service.CountryService;

public class UpdateCountryUseCase {
    private final CountryService countryService;

    public UpdateCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public Optional<Country> execute(String id, String value) {
        return countryService.updateCountry(id, value);
    }
}
