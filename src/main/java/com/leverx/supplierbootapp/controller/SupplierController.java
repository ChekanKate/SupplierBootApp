package com.leverx.supplierbootapp.controller;

import com.leverx.supplierbootapp.entity.Supplier;
import com.leverx.supplierbootapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/suppliers/{id}")
    public Supplier getSupplierById(@PathVariable Long id){
        return supplierService.findSupplierById(id);
    }

}
