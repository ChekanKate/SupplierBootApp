package com.leverx.supplierbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("supplier")
public class Supplier {

    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @MappedCollection(idColumn = "tenant_id")
    private Address address;
    @MappedCollection(idColumn = "supplier_id")
    private Set<Order> orders;

    @MappedCollection(idColumn = "id")
    private Set<Recipient> recipients;

    public Supplier(String name, Address address, Set<Order> orders, Set<Recipient> recipients) {
        this.name = name;
        this.address = address;
        this.orders = orders;
        this.recipients = recipients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<Recipient> recipients) {
        this.recipients = recipients;
    }
}
