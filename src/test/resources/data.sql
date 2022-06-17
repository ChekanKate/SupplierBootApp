INSERT INTO "supplier" VALUES
    (201, 'LeverX', 101),
    (202, 'SoftServe', 102),
    (203, 'SupplierForDelete', 102);

INSERT INTO "order" VALUES
   (401, 'Order 1 to LeverX', 30000, 201),
   (402, 'Order 2 to LeverX', 80000, 201),
   (403, 'Order 1 to SoftServe', 120000, 202);

INSERT INTO "product" ("id", "name", "price", "order_id") VALUES
   (501, 'Product 1 to Order1 to LeverX', 30000, 401),
   (502, 'Product 1 to Order2 to LeverX', 60000, 402),
   (503, 'Product 2 to Order2 to LeverX', 20000, 402),
   (504, 'Product 1 to Order1 to SoftServe', 40000, 403),
   (505, 'Product 2 to Order1 to SoftServe', 80000, 403);

INSERT INTO "address" ("address_id", "country", "city", "street", "building", "tenant_id") VALUES
    (101, 'Ukraine', 'Kyiv', 'Franka', 31, 201),
    (102, 'Poland', 'Wroclaw', 'Maja', 23, 202),
    (105, 'Ukraine', 'Mukachevo', 'Petefi', 108, 303),
    (103, 'UK', 'London', 'Some street', 34, 301),
    (104, 'Germany', 'Berlin', 'Street', 58, 302);

INSERT INTO "recipient" ("id", "name", "address_id") VALUES
   (301, 'Candy Shop', 103),
   (302, 'Beauty Salon', 104),
   (303, 'School', 105);

INSERT INTO "supplier_recipient" ("supplier_id", "recipient_id") VALUES
    (201, 301),
    (201, 302),
    (202, 301),
    (202, 303);