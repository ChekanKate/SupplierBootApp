package com.leverx.supplierbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("SUPPLIER")
public class Supplier {

    @Id
    @Column("ID")
    private Long id;
    @Column("NAME")
    private String name;
    @MappedCollection(idColumn = "TENANT_ID")
    private Address address;
    @MappedCollection(idColumn = "SUPPLIER_ID")
    private Set<Order> orders;

    @MappedCollection(idColumn = "ID")
    private Set<Recipient> recipients;

    public Supplier(String name, Address address, Set<Order> orders, Set<Recipient> recipients) {
        this.name = name;
        this.address = address;
        this.orders = orders;
        this.recipients = recipients;
    }

}
