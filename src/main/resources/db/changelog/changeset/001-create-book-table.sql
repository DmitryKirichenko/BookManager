CREATE TABLE book
(
    id          BIGSERIAL PRIMARY KEY,
    vendor_code VARCHAR(255),
    title       VARCHAR(255),
    year        INT,
    brand       VARCHAR(255),
    stock       INT,
    price       NUMERIC(10, 2)
);
