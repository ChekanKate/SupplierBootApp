package com.leverx.supplierbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@Table("RECIPIENT")
public class Recipient {

    @Id
    @Column("ID")
    private Long id;
    @Column("NAME")
    private String name;

//    @MappedCollection(idColumn = "TENANT_ID")
//    private Address address;

    @Column("ADDRESS_ID")
    private Long addressId;

}
