package com.leverx.supplierbootapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("order")
public class Order {

    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @Column("price")
    private Double price;

    @Column("supplier_id")
    private Long supplierId;

    @MappedCollection(idColumn = "order_id")
    private Set<Product> products;

    public Order(Long id, String name, Double price, Long supplierId, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.supplierId = supplierId;
        this.products = products;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
