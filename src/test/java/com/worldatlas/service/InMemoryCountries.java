package com.worldatlas.service;

import com.worldatlas.model.Country;
import com.worldatlas.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

class InMemoryCountries implements CountryRepository {

    private final List<Country> all = List.of(
            new Country("JP", "Japan", "Tokyo", "Asia", 124000000, 377975),
            new Country("IN", "India", "New Delhi", "Asia", 1428000000, 3287263));

    @Override
    public List<Country> findAll() {
        return all;
    }

    @Override
    public Optional<Country> findByCode(String code) {
        return all.stream().filter(country -> country.getCode().equals(code)).findFirst();
    }

    @Override
    public List<Country> searchByName(String namePart) {
        return all.stream().filter(country -> country.getName().contains(namePart)).toList();
    }

    @Override
    public void updatePopulation(String code, long population) {
        findByCode(code).ifPresent(country -> country.setPopulation(population));
    }
}
