package com.leverx.supplierbootapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("product")
public class Product {

    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @Column("price")
    private Integer price;
    @Column("order_id")
    private Long order_id;

    public Product(Long id, String name, Integer price, Long order_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.order_id = order_id;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(order_id, product.order_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, order_id);
    }
}
