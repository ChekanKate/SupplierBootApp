package com.leverx.supplierbootapp.repositories;

import com.leverx.supplierbootapp.entities.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    Supplier findSupplierById(Long id);

}
