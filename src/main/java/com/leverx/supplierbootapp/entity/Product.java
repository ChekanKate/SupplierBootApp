package com.leverx.supplierbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("PRODUCT")
public class Product {

    @Id
    @Column("ID")
    private Long id;
    @Column("NAME")
    private String name;
    @Column("PRICE")
    private Integer price;
    @Column("ORDER_ID")
    private Long order_id;

//    public Product(String name, Integer price, Long order_id) {
//        this.name = name;
//        this.price = price;
//        this.order_id = order_id;
//    }
}
