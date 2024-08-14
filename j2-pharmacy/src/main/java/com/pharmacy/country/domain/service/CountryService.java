package com.pharmacy.country.domain.service;

import java.util.Optional;

import com.pharmacy.country.domain.entity.Country;

public interface CountryService {
    void createCountry(Country country);
    Optional<Country> findCountry(String id);
    Optional<Country> updateCountry(String id, String value);
    void deleteCountry(String id);
}
