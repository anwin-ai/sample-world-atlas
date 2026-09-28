INSERT INTO countries (code, name, capital, continent, population, area_km2) VALUES
    ('IN', 'India', 'New Delhi', 'Asia', 1428000000, 3287263),
    ('CN', 'China', 'Beijing', 'Asia', 1410000000, 9596961),
    ('US', 'United States', 'Washington, D.C.', 'North America', 335000000, 9833520),
    ('ID', 'Indonesia', 'Jakarta', 'Asia', 277000000, 1904569),
    ('BR', 'Brazil', 'Brasilia', 'South America', 216000000, 8515767),
    ('NG', 'Nigeria', 'Abuja', 'Africa', 223000000, 923768),
    ('JP', 'Japan', 'Tokyo', 'Asia', 124000000, 377975),
    ('MX', 'Mexico', 'Mexico City', 'North America', 128000000, 1964375),
    ('DE', 'Germany', 'Berlin', 'Europe', 84000000, 357022),
    ('FR', 'France', 'Paris', 'Europe', 68000000, 643801),
    ('GB', 'United Kingdom', 'London', 'Europe', 68000000, 243610),
    ('ZA', 'South Africa', 'Pretoria', 'Africa', 62000000, 1221037),
    ('CA', 'Canada', 'Ottawa', 'North America', 40000000, 9984670),
    ('AU', 'Australia', 'Canberra', 'Oceania', 27000000, 7692024);

INSERT INTO states (id, country_code, name, capital, population) VALUES
    (1, 'IN', 'Uttar Pradesh', 'Lucknow', 241000000),
    (2, 'IN', 'Maharashtra', 'Mumbai', 126000000),
    (3, 'IN', 'Bihar', 'Patna', 128000000),
    (4, 'IN', 'West Bengal', 'Kolkata', 99000000),
    (5, 'IN', 'Tamil Nadu', 'Chennai', 77000000),
    (6, 'IN', 'Karnataka', 'Bengaluru', 67000000),
    (7, 'IN', 'Delhi', 'New Delhi', 21000000),
    (8, 'US', 'California', 'Sacramento', 39000000),
    (9, 'US', 'Texas', 'Austin', 30000000),
    (10, 'US', 'Florida', 'Tallahassee', 22000000),
    (11, 'US', 'New York', 'Albany', 20000000),
    (12, 'CN', 'Guangdong', 'Guangzhou', 127000000),
    (13, 'CN', 'Shandong', 'Jinan', 101000000),
    (14, 'BR', 'Sao Paulo', 'Sao Paulo', 46000000),
    (15, 'BR', 'Minas Gerais', 'Belo Horizonte', 20000000),
    (16, 'DE', 'North Rhine-Westphalia', 'Dusseldorf', 18000000),
    (17, 'DE', 'Bavaria', 'Munich', 13000000),
    (18, 'CA', 'Ontario', 'Toronto', 15000000),
    (19, 'CA', 'Quebec', 'Quebec City', 9000000),
    (20, 'AU', 'New South Wales', 'Sydney', 8000000),
    (21, 'AU', 'Victoria', 'Melbourne', 7000000),
    (22, 'MX', 'Mexico State', 'Toluca', 17000000),
    (23, 'NG', 'Lagos', 'Ikeja', 15000000),
    (24, 'ZA', 'Gauteng', 'Johannesburg', 16000000),
    (25, 'JP', 'Tokyo Metropolis', 'Shinjuku', 14000000);

INSERT INTO users (id, username, password_hash, email, phone, aadhaar_number, role) VALUES
    (1, 'admin', '0192023a7bbd73250516f069df18b500', 'admin@worldatlas-demo.example', '+91-9000000001', '999911112222', 'ADMIN'),
    (2, 'reader', '482c811da5d5b4bc6d497ffa98491e38', 'reader@worldatlas-demo.example', '+91-9000000002', '999933334444', 'READER');

INSERT INTO donations (donor_name, donor_email, card_number, cvv, expiry, amount_cents) VALUES
    ('Sample Donor', 'donor@worldatlas-demo.example', '4111111111111111', '123', '12/2030', 2500);
