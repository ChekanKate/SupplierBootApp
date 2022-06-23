package com.leverx.supplierbootapp.controller;

import com.leverx.supplierbootapp.dto.SupplierDTO;
import com.leverx.supplierbootapp.mapper.MapStructMapper;
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

    @Autowired
    private MapStructMapper mapStructMapper;

    @PostMapping()
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> supplierDTOS = mapStructMapper.listOfSuppliersToSuppliersDTO(supplierService.findAllSuppliers());
        return ResponseEntity.status(HttpStatus.OK).body(supplierDTOS);
    }

    @PostMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.supplierToSupplierDTO(supplierService.findSupplierById(id)));
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity deleteSupplierById(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/update")
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.supplierToSupplierDTO(
                supplierService.saveOrUpdateSupplier(mapStructMapper.supplierDTOToSupplier(supplierDTO))));
    }

    @PostMapping("/create")
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.supplierToSupplierDTO(
                supplierService.saveOrUpdateSupplier(mapStructMapper.supplierDTOToSupplier(supplierDTO))));
    }

}
