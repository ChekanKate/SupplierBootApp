package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {

    @Id
    private String id;

    private String name;
    private Integer price;
    private String orderId;

}
