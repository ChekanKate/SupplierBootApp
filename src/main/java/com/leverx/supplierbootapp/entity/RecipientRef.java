package com.leverx.supplierbootapp.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
//@AllArgsConstructor
@Table("supplier_recipient")
public class RecipientRef {

    @Column("recipient_id")
    private Long recipientId;

    public RecipientRef(Long recipientId) {
        this.recipientId = recipientId;
    }

}
