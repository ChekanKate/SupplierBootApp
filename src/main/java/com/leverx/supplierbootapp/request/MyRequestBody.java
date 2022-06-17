package com.leverx.supplierbootapp.request;

import com.leverx.supplierbootapp.entity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class MyRequestBody {

    private String action;

    private Long id;

    private Supplier supplier;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
