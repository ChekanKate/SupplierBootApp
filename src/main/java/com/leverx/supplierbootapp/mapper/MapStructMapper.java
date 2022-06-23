package com.leverx.supplierbootapp.mapper;

import com.leverx.supplierbootapp.dto.SupplierDTO;
import com.leverx.supplierbootapp.entity.Supplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    SupplierDTO supplierToSupplierDTO(Supplier supplier);

    Supplier supplierDTOToSupplier(SupplierDTO supplierDTO);

    List<SupplierDTO> listOfSuppliersToSuppliersDTO(List<Supplier> suppliers);

}
