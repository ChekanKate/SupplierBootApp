package com.leverx.supplierbootapp.repository;

import com.leverx.supplierbootapp.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
