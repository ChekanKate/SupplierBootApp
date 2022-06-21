package com.leverx.supplierbootapp.dto;

import com.leverx.supplierbootapp.entity.Address;
import com.leverx.supplierbootapp.entity.Order;
import com.leverx.supplierbootapp.entity.Recipient;
import org.springframework.hateoas.RepresentationModel;


import java.util.Set;

public class SupplierDTO extends RepresentationModel<SupplierDTO> {

    private Long id;
    private String name;
    private Address address;
    private Set<Order> orders;
    private Set<Recipient> recipients;

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
