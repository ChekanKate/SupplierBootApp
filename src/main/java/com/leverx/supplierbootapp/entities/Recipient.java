package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Data
public class Recipient {

    @Id
    private Long id;
    private String name;

    @MappedCollection(idColumn = "id")
    private Address address;
    private List<Supplier> suppliers;
}
