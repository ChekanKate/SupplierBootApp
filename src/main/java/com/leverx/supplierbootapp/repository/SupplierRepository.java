package com.leverx.supplierbootapp.repository;

import com.leverx.supplierbootapp.entity.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

}
