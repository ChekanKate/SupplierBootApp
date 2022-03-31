package com.leverx.supplierbootapp.dao;

import com.leverx.supplierbootapp.entities.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface Dao extends CrudRepository<Supplier, String> {

}
