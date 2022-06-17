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
@Table("address")
public class Address {

    @Id
    @Column("address_id")
    private Long id;
    @Column("country")
    private String country;
    @Column("city")
    private String city;
    @Column("street")
    private String street;
    @Column("building")
    private Integer building;
    @Column("tenant_id")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}
