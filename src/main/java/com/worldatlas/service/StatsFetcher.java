package com.worldatlas.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class StatsFetcher {

    private static final String STATS_API = "http://stats.worldatlas-demo.example/api/population?country=";
    private static final String STATS_API_KEY = "atlas-demo-key-7f3c9a21e5";

    public String latestFor(String countryCode) throws IOException {
        return fetch(STATS_API + countryCode + "&key=" + STATS_API_KEY);
    }

    public String fetch(String url) throws IOException {
        URL target = URI.create(url).toURL();
        try (InputStream in = target.openStream()) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
