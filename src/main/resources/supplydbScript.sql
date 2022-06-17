SET search_path = supplydb;

SELECT pg_catalog.set_config('search_path', 'public', false);

CREATE TABLE IF NOT EXISTS "address" (
    address_id SERIAL,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    building INT NOT NULL,
    tenant_id BIGINT,
    PRIMARY KEY(address_id)
);

CREATE TABLE IF NOT EXISTS "supplier" (
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    address_id BIGINT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS "order" (
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    price DECIMAL NOT NULL,
    supplier_id BIGINT,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS "product" (
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    price DECIMAL NOT NULL,
    order_id BIGINT,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS "recipient" (
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    address_id BIGINT,
    UNIQUE (address_id),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS "supplier_recipient" (
    supplier_id BIGINT REFERENCES "supplier" (id),
    recipient_id BIGINT REFERENCES "recipient" (id)
);

INSERT INTO "address" (address_id, country, city, street, building, tenant_id) VALUES
    (101, 'Ukraine', 'Kyiv', 'Franka', 31, 201),
    (102, 'Poland', 'Wroclaw', 'Maja', 23, 202),
    (103, 'Germany', 'Berlin', 'Main', 87, 303),
    (104, 'Italy', 'Rome', 'Beautiful', 5, 301),
    (105, 'Ukraine', 'Lviv', 'Shevchenka', 206, 302);

INSERT INTO "supplier" (id, name, address_id) VALUES
    (201, 'LeverX', 101),
    (202, 'SoftServe', 102);

INSERT INTO "recipient" (id, name, address_id) VALUES
    (301, 'Candy Shop', 103),
    (302, 'Beauty Salon', 104),
    (303, 'School', 105);

INSERT INTO "supplier_recipient" (supplier_id, recipient_id) VALUES
    (201, 301),
    (201, 302),
    (202, 301),
    (202, 303);

INSERT INTO "order" (id, name, price, supplier_id) VALUES
    (401, 'Order 1 to LeverX', 30000, 201),
    (402, 'Order 2 to LeverX', 80000, 201),
    (403, 'Order 1 to SoftServe', 120000, 202);

INSERT INTO "product" (id, name, price, order_id) VALUES
    (501, 'Product 1 to Order1 to LeverX', 30000, 401),
    (502, 'Product 1 to Order2 to LeverX', 60000, 402),
    (503, 'Product 2 to Order2 to LeverX', 20000, 402),
    (504, 'Product 1 to Order1 to SoftServe', 80000, 403),
    (505, 'Product 2 to Order1 to SoftServe', 40000, 403);