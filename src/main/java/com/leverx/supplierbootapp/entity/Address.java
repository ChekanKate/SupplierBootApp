package com.leverx.supplierbootapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

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

    public Address() {
    }

    public Address(Long id, String country, String city, String street, Integer building) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public Address(String country, String city, String street, Integer building, Long tenantId) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.tenantId = tenantId;
    }

    public Address(Long id, String country, String city, String street, Integer building, Long tenantId) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.tenantId = tenantId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(building, address.building) && Objects.equals(tenantId, address.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street, building, tenantId);
    }
}
