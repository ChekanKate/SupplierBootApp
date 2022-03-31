SET search_path = supplydb;

SELECT pg_catalog.set_config('search_path', 'public', false);

CREATE TABLE IF NOT EXISTS address (
    id VARCHAR(36) NOT NULL,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    building INT NOT NULL,
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS supplier (
    id VARCHAR(36) NOT NULL,
    name VARCHAR(50) NOT NULL,
    address_id VARCHAR(36) REFERENCES address (id),
    UNIQUE (address_id),
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS "order" (
    id VARCHAR(36) NOT NULL,
    name VARCHAR(50) NOT NULL,
    price DECIMAL NOT NULL,
    supplier_id VARCHAR(36) REFERENCES supplier (id),
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS product (
    id VARCHAR(36) NOT NULL,
    name VARCHAR(50) NOT NULL,
    price DECIMAL NOT NULL,
    order_id VARCHAR(36) REFERENCES "order" (id),
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS recipient (
    id VARCHAR(36) NOT NULL,
    name VARCHAR(50) NOT NULL,
    address_id VARCHAR(36) REFERENCES address (id),
    UNIQUE (address_id),
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS supplier_recipient (
    supplier_id VARCHAR(36) REFERENCES supplier (id),
    recipient_id VARCHAR(36) REFERENCES recipient (id)
    );

INSERT INTO address (id, country, city, street, building) VALUES
    ('444ffc1c-ba7e-44d4-b706-81f6e3cd3302', 'Ukraine', 'Kyiv', 'Franka', 31),
    ('3d4e1024-cc1d-4511-a03e-5818c985d2b0', 'Poland', 'Wroclaw', 'Maja', 23),
    ('f1a14b70-1964-4291-8212-23f4afe3bc8a', 'Germany', 'Berlin', 'Main', 87),
    ('58e4c97c-d941-4f89-a6c2-c6d976c45323', 'Italy', 'Rome', 'Beautiful', 5),
    ('90595616-f689-4396-82c6-ec59bae3ec53', 'Ukraine', 'Lviv', 'Shevchenka', 206);

INSERT INTO supplier (id, name, address_id) VALUES
    ('1d40f846-fd85-4907-abbc-6a986a4e479f', 'LeverX', '444ffc1c-ba7e-44d4-b706-81f6e3cd3302'),
    ('2f393190-aa3e-469f-a284-102b3c9158ca', 'SoftServe', '3d4e1024-cc1d-4511-a03e-5818c985d2b0');

INSERT INTO recipient (id, name, address_id) VALUES
    ('107c5683-dd2a-4dc1-aa75-89ef78347e5e', 'Candy Shop', 'f1a14b70-1964-4291-8212-23f4afe3bc8a'),
    ('50b0d987-34da-4aac-9ed5-63fe61ae30a7', 'Beauty Salon', '58e4c97c-d941-4f89-a6c2-c6d976c45323'),
    ('67a7865d-a6f2-4a55-96c5-7d577df8c63c', 'School', '90595616-f689-4396-82c6-ec59bae3ec53');

INSERT INTO supplier_recipient (supplier_id, recipient_id) VALUES
    ('1d40f846-fd85-4907-abbc-6a986a4e479f', '107c5683-dd2a-4dc1-aa75-89ef78347e5e'),
    ('1d40f846-fd85-4907-abbc-6a986a4e479f', '50b0d987-34da-4aac-9ed5-63fe61ae30a7'),
    ('2f393190-aa3e-469f-a284-102b3c9158ca', '107c5683-dd2a-4dc1-aa75-89ef78347e5e'),
    ('2f393190-aa3e-469f-a284-102b3c9158ca', '67a7865d-a6f2-4a55-96c5-7d577df8c63c');

INSERT INTO "order" (id, name, price, supplier_id) VALUES
    ('73bf790c-de94-4efa-a3e4-2f94f81c27bf', 'Order 1 to LeverX', 30000, '1d40f846-fd85-4907-abbc-6a986a4e479f'),
    ('b1f1de4c-7ab9-47b9-ae66-328586fd74f8', 'Order 2 to LeverX', 80000, '1d40f846-fd85-4907-abbc-6a986a4e479f'),
    ('86492d30-1113-477f-ada2-ff15514a0d87', 'Order 1 to SoftServe', 120000, '2f393190-aa3e-469f-a284-102b3c9158ca');

INSERT INTO product (id, name, price, order_id) VALUES
    ('ed3eb2c8-b12b-4372-a409-b38c4d865564', 'Product 1 to Order1 to LeverX', 30000, '73bf790c-de94-4efa-a3e4-2f94f81c27bf'),
    ('95fdcb68-a76a-459b-a5e9-2b242b1f9aef', 'Product 1 to Order2 to LeverX', 60000, 'b1f1de4c-7ab9-47b9-ae66-328586fd74f8'),
    ('1b56430f-41da-450f-a593-3663f758218a', 'Product 2 to Order2 to LeverX', 20000, 'b1f1de4c-7ab9-47b9-ae66-328586fd74f8'),
    ('2541c90c-434a-4ba0-84ab-34a25b4a2af0', 'Product 1 to Order1 to SoftServe', 80000, '86492d30-1113-477f-ada2-ff15514a0d87'),
    ('3a06986b-e69d-4731-909d-ac50361e7eb6', 'Product 2 to Order1 to SoftServe', 40000, '86492d30-1113-477f-ada2-ff15514a0d87');