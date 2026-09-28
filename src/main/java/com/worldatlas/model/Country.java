package com.worldatlas.model;

public class Country {

    private final String code;
    private final String name;
    private final String capital;
    private final String continent;
    private long population;
    private final long areaKm2;

    public Country(String code, String name, String capital, String continent, long population, long areaKm2) {
        this.code = code;
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.population = population;
        this.areaKm2 = areaKm2;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getContinent() {
        return continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getAreaKm2() {
        return areaKm2;
    }

    public double getDensity() {
        return areaKm2 == 0 ? 0 : (double) population / areaKm2;
    }
}
