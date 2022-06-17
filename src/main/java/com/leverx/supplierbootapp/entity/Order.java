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
@Table("order")
public class Order {

    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @Column("price")
    private Double price;

    ///add link to supplier
    @Column("supplier_id")
    private Long supplierId;

    @MappedCollection(idColumn = "order_id")
    private Set<Product> products;

//    public Order(String name, Double price, Long supplierId, Set<Product> products) {
//        this.name = name;
//        this.price = price;
//        this.supplierId = supplierId;
//        this.products = products;
//    }
}
