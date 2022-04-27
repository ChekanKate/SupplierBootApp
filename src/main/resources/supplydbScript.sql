SET search_path = supplydb;

SELECT pg_catalog.set_config('search_path', 'public', false);

CREATE TABLE IF NOT EXISTS "ADDRESS" (
    "ADDRESS_ID" SERIAL,
    "COUNTRY" VARCHAR(50) NOT NULL,
    "CITY" VARCHAR(50) NOT NULL,
    "STREET" VARCHAR(50) NOT NULL,
    "BUILDING" INT NOT NULL,
    PRIMARY KEY("ADDRESS_ID")
);

CREATE TABLE IF NOT EXISTS "SUPPLIER" (
     "ID" SERIAL,
     "NAME" VARCHAR(50) NOT NULL,
     "ADDRESS_ID" BIGINT NULL,
     FOREIGN KEY ("ADDRESS_ID") REFERENCES "ADDRESS" ("ADDRESS_ID"),
     PRIMARY KEY("ID")
);

CREATE TABLE IF NOT EXISTS "ORDER" (
     "ID" SERIAL,
     "NAME" VARCHAR(50) NOT NULL,
     "PRICE" DECIMAL NOT NULL,
     "SUPPLIER_ID" BIGINT REFERENCES "SUPPLIER" ("ID"),
     PRIMARY KEY("ID")
);

CREATE TABLE IF NOT EXISTS "PRODUCT" (
     "ID" SERIAL,
     "NAME" VARCHAR(50) NOT NULL,
     "PRICE" DECIMAL NOT NULL,
     "ORDER_ID" BIGINT REFERENCES "ORDER" ("ID"),
     PRIMARY KEY("ID")
);

CREATE TABLE IF NOT EXISTS "RECIPIENT" (
    "ID" SERIAL,
    "NAME" VARCHAR(50) NOT NULL,
    "ADDRESS_ID" BIGINT REFERENCES "ADDRESS" ("ADDRESS_ID"),
    UNIQUE ("ADDRESS_ID"),
    PRIMARY KEY("ID")
);

CREATE TABLE IF NOT EXISTS "SUPPLIER_RECIPIENT" (
     "SUPPLIER_ID" BIGINT REFERENCES "SUPPLIER" ("ID"),
     "RECIPIENT_ID" BIGINT REFERENCES "RECIPIENT" ("ID")
);

INSERT INTO "ADDRESS" ("ADDRESS_ID", "COUNTRY", "CITY", "STREET", "BUILDING") VALUES
     (101, 'Ukraine', 'Kyiv', 'Franka', 31),
     (102, 'Poland', 'Wroclaw', 'Maja', 23),
     (103, 'Germany', 'Berlin', 'Main', 87),
     (104, 'Italy', 'Rome', 'Beautiful', 5),
     (105, 'Ukraine', 'Lviv', 'Shevchenka', 206);

INSERT INTO "SUPPLIER" ("ID", "NAME", "ADDRESS_ID") VALUES
      (201, 'LeverX', 101),
      (202, 'SoftServe', 102);

INSERT INTO "RECIPIENT" ("ID", "NAME", "ADDRESS_ID") VALUES
     (301, 'Candy Shop', 103),
     (302, 'Beauty Salon', 104),
     (303, 'School', 105);

INSERT INTO "SUPPLIER_RECIPIENT" ("SUPPLIER_ID", "RECIPIENT_ID") VALUES
     (201, 301),
     (201, 302),
     (202, 301),
     (202, 303);

INSERT INTO "ORDER" ("ID", "NAME", "PRICE", "SUPPLIER_ID") VALUES
     (401, 'Order 1 to LeverX', 30000, 201),
     (402, 'Order 2 to LeverX', 80000, 201),
     (403, 'Order 1 to SoftServe', 120000, 202);

INSERT INTO "PRODUCT" ("ID", "NAME", "PRICE", "ORDER_ID") VALUES
     (501, 'Product 1 to Order1 to LeverX', 30000, 401),
     (502, 'Product 1 to Order2 to LeverX', 60000, 402),
     (503, 'Product 2 to Order2 to LeverX', 20000, 402),
     (504, 'Product 1 to Order1 to SoftServe', 80000, 403),
     (505, 'Product 2 to Order1 to SoftServe', 40000, 403);