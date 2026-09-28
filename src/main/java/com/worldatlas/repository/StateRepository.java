package com.worldatlas.repository;

import com.worldatlas.model.State;

import java.util.List;

public interface StateRepository {

    List<State> findByCountry(String countryCode);

    List<State> findLargest(int limit);
}
