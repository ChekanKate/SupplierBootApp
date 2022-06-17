package com.leverx.supplierbootapp.controller;

import com.leverx.supplierbootapp.entity.Supplier;
import com.leverx.supplierbootapp.request.MyRequestBody;
import com.leverx.supplierbootapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1")
public class SupplierControllerL0 {

    @Autowired
    private SupplierService supplierService;

    @PostMapping(value = "/suppliers")
    public ResponseEntity<List<Supplier>> allActionsWithSupplier(@RequestBody MyRequestBody request) {
        List<Supplier> result = new ArrayList<>();
        String action = request.getAction();

        if(Objects.equals(action, "GET")) {
            Long id = request.getId();
            result = getSuppliers(id);
        } else if(Objects.equals(action, "POST") || Objects.equals(action, "PUT") || Objects.equals(action, "PATCH")) {
            Supplier supplier = request.getSupplier();
            result.add(postSupplier(supplier));
        } else if(Objects.equals(action, "DELETE")) {
            Long id = request.getId();
            deleteSupplier(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public List<Supplier> getSuppliers(Long id){
        List<Supplier> supplierList = new ArrayList<>();
        if(id != null) {
            supplierList.add(supplierService.findSupplierById(Long.valueOf(id)));
        } else {
            supplierList = supplierService.findAllSuppliers();
        }
        return supplierList;
    }

    public Supplier postSupplier(Supplier supplier){
        return supplierService.saveOrUpdateSupplier(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierService.deleteSupplierById(id);
    }

}
