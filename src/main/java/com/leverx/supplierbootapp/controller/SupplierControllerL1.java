package com.leverx.supplierbootapp.controller;

import com.leverx.supplierbootapp.dto.SupplierDTO;
import com.leverx.supplierbootapp.mapper.MapStructMapper;
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
public class SupplierControllerL1 {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private MapStructMapper mapStructMapper;

    @PostMapping(value = "/suppliers")
    public ResponseEntity<List<SupplierDTO>> allActionsWithSupplier(@RequestBody MyRequestBody request) {
        List<SupplierDTO> result = new ArrayList<>();
        String action = request.getAction();

        if(Objects.equals(action, "GET")) {
            Long id = request.getId();
            result = getSuppliers(id);
        } else if(Objects.equals(action, "POST") || Objects.equals(action, "PUT") || Objects.equals(action, "PATCH")) {
            SupplierDTO supplierDTO = request.getSupplierDTO();
            result.add(postSupplier(supplierDTO));
        } else if(Objects.equals(action, "DELETE")) {
            Long id = request.getId();
            deleteSupplier(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public List<SupplierDTO> getSuppliers(Long id){
        List<SupplierDTO> supplierDTOList = new ArrayList<>();
        if(id != null) {
            supplierDTOList.add(mapStructMapper.supplierToSupplierDTO(supplierService.findSupplierById(Long.valueOf(id))));
        } else {
            supplierDTOList = mapStructMapper.listOfSuppliersToSuppliersDTO(supplierService.findAllSuppliers());
        }
        return supplierDTOList;
    }

    public SupplierDTO postSupplier(SupplierDTO supplierDTO){
        return mapStructMapper.supplierToSupplierDTO(supplierService.saveOrUpdateSupplier(mapStructMapper.supplierDTOToSupplier(supplierDTO)));
    }

    public void deleteSupplier(Long id) {
        supplierService.deleteSupplierById(id);
    }

}
