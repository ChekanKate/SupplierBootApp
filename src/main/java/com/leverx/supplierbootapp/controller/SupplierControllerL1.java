package com.leverx.supplierbootapp.controller;

import com.leverx.supplierbootapp.entity.Supplier;
import com.leverx.supplierbootapp.request.MyRequestBody;
import com.leverx.supplierbootapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/suppliers")
public class SupplierControllerL1 {

    @Autowired
    private SupplierService supplierService;

    @PostMapping()
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.findAllSuppliers());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.findSupplierById(id));
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity deleteSupplierById(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/update")
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.saveOrUpdateSupplier(supplier));
    }

    @PostMapping("/create")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.saveOrUpdateSupplier(supplier));
    }

}
