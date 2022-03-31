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
    @MappedCollection(idColumn = "recipient_id")
    private List<SupplierRef> suppliers;

    public void addSupplier(Supplier supplier) {
        suppliers.add(new SupplierRef(supplier.getId()));
    }
}
