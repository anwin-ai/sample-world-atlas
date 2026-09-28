CREATE TABLE IF NOT EXISTS countries (
    code VARCHAR(2) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    capital VARCHAR(100) NOT NULL,
    continent VARCHAR(30) NOT NULL,
    population BIGINT NOT NULL,
    area_km2 BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS states (
    id BIGINT PRIMARY KEY,
    country_code VARCHAR(2) NOT NULL REFERENCES countries(code),
    name VARCHAR(100) NOT NULL,
    capital VARCHAR(100) NOT NULL,
    population BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(64) NOT NULL,
    email VARCHAR(120),
    phone VARCHAR(20),
    aadhaar_number VARCHAR(12),
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS donations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    donor_name VARCHAR(100),
    donor_email VARCHAR(120),
    card_number VARCHAR(19),
    cvv VARCHAR(4),
    expiry VARCHAR(7),
    amount_cents BIGINT
);
