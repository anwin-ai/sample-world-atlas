package com.worldatlas.model;

public class State {

    private final long id;
    private final String countryCode;
    private final String name;
    private final String capital;
    private final long population;

    public State(long id, String countryCode, String name, String capital, long population) {
        this.id = id;
        this.countryCode = countryCode;
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }
}
