package com.leverx.supplierbootapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table("supplier_recipient")
@Data
@AllArgsConstructor
public class RecipientRef {

    Long recipientId;

}
