package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Data
public class Recipient {

    @Id
    private String id;

    private String name;

    @MappedCollection(idColumn = "address_id")
    private Address address;

}
