package com.worldatlas.service;

import com.worldatlas.audit.AuditLogger;
import com.worldatlas.model.Country;
import com.worldatlas.repository.CountryRepository;

public class PopulationService {

    private final CountryRepository countries;
    private final AuditLogger audit;

    public PopulationService(CountryRepository countries, AuditLogger audit) {
        this.countries = countries;
        this.audit = audit;
    }

    public void updatePopulation(String code, long newPopulation, String changedBy) {
        Country country = countries.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Unknown country: " + code));
        long old = country.getPopulation();
        countries.updatePopulation(code, newPopulation);
        audit.populationChanged(code, old, newPopulation, changedBy);
    }

    public long worldPopulation() {
        return countries.findAll().stream().mapToLong(Country::getPopulation).sum();
    }
}
