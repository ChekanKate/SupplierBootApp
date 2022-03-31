package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Data
public class Supplier {

    @Id
    private String id;

    private String name;

    @MappedCollection(idColumn = "address_id")
    private Address address;
    @MappedCollection(keyColumn = "supplier_id", idColumn = "supplier_id")
    private List<Order> orders;

}
