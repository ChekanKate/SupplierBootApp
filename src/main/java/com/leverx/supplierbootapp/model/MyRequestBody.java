package com.leverx.supplierbootapp.model;

import com.leverx.supplierbootapp.dto.SupplierDTO;
import org.springframework.stereotype.Component;

@Component
public class MyRequestBody {

    private String action;

    private Long id;

    private SupplierDTO supplierDTO;

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

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }
}
