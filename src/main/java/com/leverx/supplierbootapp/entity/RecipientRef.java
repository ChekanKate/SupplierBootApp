package com.leverx.supplierbootapp.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
//@AllArgsConstructor
@Table("SUPPLIER_RECIPIENT")
public class RecipientRef {

    @Column("RECIPIENT_ID")
    private Long recipientId;

    public RecipientRef(Long recipientId) {
        this.recipientId = recipientId;
    }

}
