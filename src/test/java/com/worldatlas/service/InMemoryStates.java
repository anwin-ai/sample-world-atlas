package com.worldatlas.service;

import com.worldatlas.model.State;
import com.worldatlas.repository.StateRepository;

import java.util.List;

class InMemoryStates implements StateRepository {

    @Override
    public List<State> findByCountry(String countryCode) {
        return List.of();
    }

    @Override
    public List<State> findLargest(int limit) {
        return List.of();
    }
}
