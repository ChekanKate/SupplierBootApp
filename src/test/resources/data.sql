INSERT INTO "SUPPLIER" VALUES
    (201, 'LeverX', 101),
    (202, 'SoftServe', 102),
    (203, 'SupplierForDelete', 102);

INSERT INTO "ORDER" VALUES
   (401, 'Order 1 to LeverX', 30000, 201),
   (402, 'Order 2 to LeverX', 80000, 201),
   (403, 'Order 1 to SoftServe', 120000, 202);

INSERT INTO "PRODUCT" ("ID", "NAME", "PRICE", "ORDER_ID") VALUES
   (501, 'Product 1 to Order1 to LeverX', 30000, 401),
   (502, 'Product 1 to Order2 to LeverX', 60000, 402),
   (503, 'Product 2 to Order2 to LeverX', 20000, 402),
   (504, 'Product 1 to Order1 to SoftServe', 40000, 403),
   (505, 'Product 2 to Order1 to SoftServe', 80000, 403);

INSERT INTO "ADDRESS" ("ADDRESS_ID", "COUNTRY", "CITY", "STREET", "BUILDING", "TENANT_ID") VALUES
    (101, 'Ukraine', 'Kyiv', 'Franka', 31, 201),
    (102, 'Poland', 'Wroclaw', 'Maja', 23, 202),
    (105, 'Ukraine', 'Mukachevo', 'Petefi', 108, 303),
    (103, 'UK', 'London', 'Some street', 34, 301),
    (104, 'Germany', 'Berlin', 'Street', 58, 302);

INSERT INTO "RECIPIENT" ("ID", "NAME", "ADDRESS_ID") VALUES
   (301, 'Candy Shop', 103),
   (302, 'Beauty Salon', 104),
   (303, 'School', 105);

INSERT INTO "SUPPLIER_RECIPIENT" ("SUPPLIER_ID", "RECIPIENT_ID") VALUES
    (201, 301),
    (201, 302),
    (202, 301),
    (202, 303);