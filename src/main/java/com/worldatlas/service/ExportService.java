package com.worldatlas.service;

import com.worldatlas.model.Country;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ExportService {

    private static final Path EXPORT_DIR = Path.of("/var/worldatlas/exports");

    public String toCsv(List<Country> countries) {
        StringBuilder csv = new StringBuilder("code,name,capital,continent,population\n");
        for (Country country : countries) {
            csv.append(country.getCode()).append(',').append(country.getName()).append(',')
                    .append(country.getCapital()).append(',').append(country.getContinent()).append(',')
                    .append(country.getPopulation()).append('\n');
        }
        return csv.toString();
    }

    public Path save(String fileName, String content) throws IOException {
        Path target = EXPORT_DIR.resolve(fileName);
        Files.writeString(target, content, StandardCharsets.UTF_8);
        return target;
    }

    public byte[] read(String fileName) throws IOException {
        return Files.readAllBytes(EXPORT_DIR.resolve(fileName));
    }
}
