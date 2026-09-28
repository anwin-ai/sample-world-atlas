package com.worldatlas.repository;

import com.worldatlas.model.Country;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class CachedCountryRepository implements CountryRepository {

    private final CountryRepository delegate;
    private final Map<String, Country> byCode = new ConcurrentHashMap<>();

    public CachedCountryRepository(CountryRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<Country> findAll() {
        List<Country> all = delegate.findAll();
        all.forEach(country -> byCode.put(country.getCode(), country));
        return all;
    }

    @Override
    public Optional<Country> findByCode(String code) {
        Country cached = byCode.get(code);
        if (cached != null) {
            return Optional.of(cached);
        }
        Optional<Country> loaded = delegate.findByCode(code);
        loaded.ifPresent(country -> byCode.put(code, country));
        return loaded;
    }

    @Override
    public List<Country> searchByName(String namePart) {
        return delegate.searchByName(namePart);
    }

    @Override
    public void updatePopulation(String code, long population) {
        delegate.updatePopulation(code, population);
        byCode.remove(code);
    }
}
