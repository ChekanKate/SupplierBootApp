package com.leverx.supplierbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
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

//    public Product(String name, Integer price, Long order_id) {
//        this.name = name;
//        this.price = price;
//        this.order_id = order_id;
//    }
}
