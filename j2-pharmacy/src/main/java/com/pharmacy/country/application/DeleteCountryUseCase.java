package com.pharmacy.country.application;

import com.pharmacy.country.domain.service.CountryService;

public class DeleteCountryUseCase {
    private final CountryService countryService;

    public DeleteCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public void execute(String id) {
        countryService.deleteCountry(id);
    }
}
