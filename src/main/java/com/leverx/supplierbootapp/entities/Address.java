package com.leverx.supplierbootapp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {

    @Id
    private String id;

    private String country;
    private String city;
    private Integer building;

}
