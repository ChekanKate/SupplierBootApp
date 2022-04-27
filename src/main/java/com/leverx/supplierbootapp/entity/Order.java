package com.leverx.supplierbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@AllArgsConstructor
@Table("ORDER")
public class Order {

    @Id
    @Column("ID")
    private Long id;
    @Column("NAME")
    private String name;
    @Column("PRICE")
    private Double price;

    ///add link to supplier
    @Column("SUPPLIER_ID")
    private Long supplierId;

    @MappedCollection(idColumn = "ORDER_ID")
    private Set<Product> products;

//    public Order(String name, Double price, Long supplierId, Set<Product> products) {
//        this.name = name;
//        this.price = price;
//        this.supplierId = supplierId;
//        this.products = products;
//    }
}
