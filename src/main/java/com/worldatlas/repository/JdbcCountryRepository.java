package com.worldatlas.repository;

import com.worldatlas.db.Database;
import com.worldatlas.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcCountryRepository implements CountryRepository {

    @Override
    public List<Country> findAll() {
        return query("SELECT code, name, capital, continent, population, area_km2 FROM countries ORDER BY name");
    }

    @Override
    public Optional<Country> findByCode(String code) {
        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT code, name, capital, continent, population, area_km2 FROM countries WHERE code = ?")) {
            statement.setString(1, code);
            try (ResultSet rows = statement.executeQuery()) {
                return rows.next() ? Optional.of(map(rows)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Country lookup failed", e);
        }
    }

    @Override
    public List<Country> searchByName(String namePart) {
        return query("SELECT code, name, capital, continent, population, area_km2 FROM countries WHERE name LIKE '%"
                + namePart + "%' ORDER BY name");
    }

    @Override
    public void updatePopulation(String code, long population) {
        try (Connection connection = Database.connect();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE countries SET population = " + population + " WHERE code = '" + code + "'");
        } catch (SQLException e) {
            throw new IllegalStateException("Population update failed", e);
        }
    }

    private List<Country> query(String sql) {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = Database.connect();
             Statement statement = connection.createStatement();
             ResultSet rows = statement.executeQuery(sql)) {
            while (rows.next()) {
                countries.add(map(rows));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Country query failed: " + sql, e);
        }
        return countries;
    }

    private Country map(ResultSet rows) throws SQLException {
        return new Country(rows.getString("code"), rows.getString("name"), rows.getString("capital"),
                rows.getString("continent"), rows.getLong("population"), rows.getLong("area_km2"));
    }
}
