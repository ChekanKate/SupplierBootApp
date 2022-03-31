package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Order {

    @Id
    private String id;

    private String name;
    private Double price;
    private String supplierId;

}
