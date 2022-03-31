package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Data
public class Supplier {

    @Id
    private Long id;
    private String name;

    @MappedCollection(idColumn = "id")
    private Address address;
    @MappedCollection(idColumn = "supplier_id", keyColumn = "id")
    private List<Order> orders;
    @MappedCollection(idColumn = "supplier_id")
    private List<RecipientRef> recipients;

    public void addRecipient(Recipient recipient) {
        recipients.add(new RecipientRef(recipient.getId()));
    }

}
