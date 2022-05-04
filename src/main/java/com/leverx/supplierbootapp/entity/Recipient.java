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
@Table("RECIPIENT")
public class Recipient {

    @Id
    @Column("ID")
    private Long id;
    @Column("NAME")
    private String name;
    @MappedCollection(idColumn = "TENANT_ID")
    private Set<Address> address;

//    @Column("ADDRESS_ID")
//    private Long addressId;

}
