package com.leverx.supplierbootapp.controller;

import com.leverx.supplierbootapp.entity.Supplier;
import com.leverx.supplierbootapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v4/suppliers")
public class SupplierControllerL3 {

    @Autowired
    private SupplierService supplierService;

//    @GetMapping()
//    public CollectionModel<Supplier> getAllSuppliers(){
//        List<Supplier> supplierList = supplierService.findAllSuppliers();
//        for(Supplier supplier : supplierList) {
//            Long supplierId = supplier.getId();
//            Link selfLink = linkTo(SupplierControllerL3.class).slash(supplierId).withSelfRel();
//            supplier.add(selfLink);
//        }
//        Link link = linkTo(SupplierControllerL3.class).withSelfRel();
//        CollectionModel<Supplier> result = CollectionModel.of(supplierList, link);
//        return result;
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierById(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.saveOrUpdateSupplier(supplier));
    }

    @PostMapping()
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.saveOrUpdateSupplier(supplier));
    }

}
