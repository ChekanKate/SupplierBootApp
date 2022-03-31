package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Data
public class Product {

    @Id
    private Long id;
    private String name;
    private Integer price;

    @MappedCollection(idColumn = "id")
    private Order order;

}
