package com.leverx.supplierbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("ADDRESS")
public class Address {

    @Id
    @Column("ADDRESS_ID")
    private Long id;
    @Column("COUNTRY")
    private String country;
    @Column("CITY")
    private String city;
    @Column("STREET")
    private String street;
    @Column("BUILDING")
    private Integer building;
    @Column("TENANT_ID")
    private Long tenantId;

    public Address(String country, String city, String street, Integer building) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    @PersistenceConstructor
    public Address(Long id, String country, String city, String street, Integer building) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
    }
}
