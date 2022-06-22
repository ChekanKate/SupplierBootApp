package com.leverx.supplierbootapp.controller;

import com.leverx.supplierbootapp.dto.SupplierDTO;
import com.leverx.supplierbootapp.entity.Supplier;
import com.leverx.supplierbootapp.mapper.MapStructMapper;
import com.leverx.supplierbootapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v3/suppliers")
public class SupplierControllerL2 {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping()
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers(){
        List<Supplier> supplierList = supplierService.findAllSuppliers();
        List<SupplierDTO> supplierDTOS = new ArrayList<>();
        for(int i = 0; i < supplierList.size(); i++) {
            supplierDTOS.add(mapStructMapper.supplierToSupplierDTO(supplierList.get(i)));
        }
        return ResponseEntity.status(HttpStatus.OK).body(supplierDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapStructMapper.supplierToSupplierDTO(supplierService.findSupplierById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSupplierById(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.supplierToSupplierDTO(
                supplierService.saveOrUpdateSupplier(mapStructMapper.supplierDTOToSupplier(supplierDTO))));
    }

    @PostMapping()
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapStructMapper.supplierToSupplierDTO(
                supplierService.saveOrUpdateSupplier(mapStructMapper.supplierDTOToSupplier(supplierDTO))));
    }

}
