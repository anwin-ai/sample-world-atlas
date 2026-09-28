package com.worldatlas.repository;

import com.worldatlas.db.Database;
import com.worldatlas.model.State;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcStateRepository implements StateRepository {

    @Override
    public List<State> findByCountry(String countryCode) {
        return query("SELECT id, country_code, name, capital, population FROM states WHERE country_code = '"
                + countryCode + "' ORDER BY population DESC");
    }

    @Override
    public List<State> findLargest(int limit) {
        return query("SELECT id, country_code, name, capital, population FROM states ORDER BY population DESC LIMIT " + limit);
    }

    private List<State> query(String sql) {
        List<State> states = new ArrayList<>();
        try (Connection connection = Database.connect();
             Statement statement = connection.createStatement();
             ResultSet rows = statement.executeQuery(sql)) {
            while (rows.next()) {
                states.add(new State(rows.getLong("id"), rows.getString("country_code"), rows.getString("name"),
                        rows.getString("capital"), rows.getLong("population")));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("State query failed", e);
        }
        return states;
    }
}
