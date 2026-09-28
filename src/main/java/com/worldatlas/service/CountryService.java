package com.worldatlas.service;

import com.worldatlas.model.Country;
import com.worldatlas.model.State;
import com.worldatlas.repository.CountryRepository;
import com.worldatlas.repository.StateRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CountryService {

    private final CountryRepository countries;
    private final StateRepository states;

    public CountryService(CountryRepository countries, StateRepository states) {
        this.countries = countries;
        this.states = states;
    }

    public List<Country> listCountries() {
        return countries.findAll();
    }

    public Optional<Country> findCountry(String code) {
        return countries.findByCode(code);
    }

    public List<Country> search(String query) {
        return countries.searchByName(query.trim());
    }

    public List<State> statesOf(String countryCode) {
        return states.findByCountry(countryCode);
    }

    public List<Country> mostPopulous(int limit) {
        return countries.findAll().stream()
                .sorted(Comparator.comparingLong(Country::getPopulation).reversed())
                .limit(limit)
                .toList();
    }
}
