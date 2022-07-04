package com.leverx.supplierbootapp.controller;

import com.leverx.supplierbootapp.dto.SupplierDTO;
import com.leverx.supplierbootapp.mapper.MapStructMapper;
import com.leverx.supplierbootapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/v4/suppliers")
public class SupplierControllerL4 {

    private final SupplierService supplierService;
    private final MapStructMapper mapStructMapper;

    @Autowired
    public SupplierControllerL4(SupplierService supplierService, MapStructMapper mapStructMapper) {
        this.supplierService = supplierService;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping
    public CollectionModel<SupplierDTO> getAllSuppliers(){
        List<SupplierDTO> supplierDTOS = mapStructMapper.listOfSuppliersToSuppliersDTO(supplierService.findAllSuppliers());
        for(SupplierDTO supplierDTO : supplierDTOS) {
            Long supplierId = supplierDTO.getId();
            Link selfLink = linkTo(SupplierControllerL4.class).slash(supplierId).withSelfRel();
            supplierDTO.add(selfLink);
        }
        Link link = linkTo(SupplierControllerL4.class).withSelfRel();
        CollectionModel<SupplierDTO> result = CollectionModel.of(supplierDTOS, link);
        return result;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        SupplierDTO supplierDTO = mapStructMapper.supplierToSupplierDTO(supplierService.findSupplierById(id));
        supplierDTO.add(linkTo(methodOn(SupplierControllerL4.class).getSupplierById(id)).withSelfRel());
        supplierDTO.add(linkTo(methodOn(SupplierControllerL4.class).getAllSuppliers()).withRel("allSuppliers"));
        return ResponseEntity.status(HttpStatus.OK).body(supplierDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierById(@PathVariable Long id) {
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
        return ResponseEntity.status(HttpStatus.CREATED).body(mapStructMapper.supplierToSupplierDTO(
                supplierService.saveOrUpdateSupplier(mapStructMapper.supplierDTOToSupplier(supplierDTO))));
    }

}
