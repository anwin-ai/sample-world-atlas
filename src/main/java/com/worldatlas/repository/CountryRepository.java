package com.worldatlas.repository;

import com.worldatlas.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {

    List<Country> findAll();

    Optional<Country> findByCode(String code);

    List<Country> searchByName(String namePart);

    void updatePopulation(String code, long population);
}
