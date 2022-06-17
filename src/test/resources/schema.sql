CREATE TABLE IF NOT EXISTS "address" (
   "address_id" BIGINT NOT NULL AUTO_INCREMENT,
   "country" VARCHAR(50) NOT NULL,
   "city" VARCHAR(50) NOT NULL,
   "street" VARCHAR(50) NOT NULL,
   "building" INT NOT NULL,
   "tenant_id" BIGINT,
   PRIMARY KEY("address_id")
);

CREATE TABLE IF NOT EXISTS "supplier" (
    "id" BIGINT NOT NULL AUTO_INCREMENT,
    "name" VARCHAR(50) NOT NULL,
    "address_id" BIGINT,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "order" (
    "id" BIGINT NOT NULL AUTO_INCREMENT,
    "name" VARCHAR(50) NOT NULL,
    "price" DECIMAL NOT NULL,
    "supplier_id" BIGINT,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "product" (
    "id" BIGINT NOT NULL AUTO_INCREMENT,
    "name" VARCHAR(50) NOT NULL,
    "price" DECIMAL NOT NULL,
    "order_id" BIGINT,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "recipient" (
    "id" BIGINT NOT NULL,
    "name" VARCHAR(50) NOT NULL,
    "address_id" BIGINT,
    UNIQUE ("address_id"),
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "supplier_recipient" (
    "supplier_id" BIGINT,
    "recipient_id" BIGINT
);