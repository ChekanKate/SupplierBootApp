package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Data
public class Order {

    @Id
    private Long id;
    private String name;
    private Double price;

    @MappedCollection(idColumn = "id")
    private Supplier supplier;
    @MappedCollection(idColumn = "order_id", keyColumn = "id")
    private List<Product> products;

}
