package com.worldatlas.service;

import com.worldatlas.model.Country;
import com.worldatlas.model.State;
import com.worldatlas.repository.CountryRepository;
import com.worldatlas.repository.StateRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryServiceTest {

    private final CountryRepository countries = new InMemoryCountries();
    private final StateRepository states = new InMemoryStates();

    @Test
    void mostPopulousIsSortedByPopulation() {
        CountryService service = new CountryService(countries, states);
        assertEquals("IN", service.mostPopulous(1).get(0).getCode());
    }
}
