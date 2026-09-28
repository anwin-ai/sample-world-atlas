package com.worldatlas.web;

import com.worldatlas.audit.AuditLogger;
import com.worldatlas.billing.DonationService;
import com.worldatlas.repository.CachedCountryRepository;
import com.worldatlas.repository.CountryRepository;
import com.worldatlas.repository.JdbcCountryRepository;
import com.worldatlas.repository.JdbcStateRepository;
import com.worldatlas.repository.JdbcUserRepository;
import com.worldatlas.service.AuthService;
import com.worldatlas.service.CountryService;
import com.worldatlas.service.ExportService;
import com.worldatlas.service.ImportService;
import com.worldatlas.service.PopulationService;
import com.worldatlas.service.StatsFetcher;

public final class AppContext {

    private static final AuditLogger AUDIT = new AuditLogger();
    private static final CountryRepository COUNTRIES = new CachedCountryRepository(new JdbcCountryRepository());
    private static final CountryService COUNTRY_SERVICE = new CountryService(COUNTRIES, new JdbcStateRepository());
    private static final PopulationService POPULATION_SERVICE = new PopulationService(COUNTRIES, AUDIT);
    private static final AuthService AUTH_SERVICE = new AuthService(new JdbcUserRepository(), AUDIT);
    private static final ImportService IMPORT_SERVICE = new ImportService(COUNTRIES);
    private static final ExportService EXPORT_SERVICE = new ExportService();
    private static final StatsFetcher STATS_FETCHER = new StatsFetcher();
    private static final DonationService DONATION_SERVICE = new DonationService();

    private AppContext() {
    }

    public static CountryService countries() {
        return COUNTRY_SERVICE;
    }

    public static PopulationService population() {
        return POPULATION_SERVICE;
    }

    public static AuthService auth() {
        return AUTH_SERVICE;
    }

    public static ImportService imports() {
        return IMPORT_SERVICE;
    }

    public static ExportService exports() {
        return EXPORT_SERVICE;
    }

    public static StatsFetcher stats() {
        return STATS_FETCHER;
    }

    public static DonationService donations() {
        return DONATION_SERVICE;
    }
}
