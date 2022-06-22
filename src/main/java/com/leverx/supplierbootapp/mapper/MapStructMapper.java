package com.leverx.supplierbootapp.mapper;

import com.leverx.supplierbootapp.dto.SupplierDTO;
import com.leverx.supplierbootapp.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    SupplierDTO supplierToSupplierDTO(Supplier supplier);

    Supplier supplierDTOToSupplier(SupplierDTO supplierDTO);

}
