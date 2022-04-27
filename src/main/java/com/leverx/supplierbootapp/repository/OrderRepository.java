package com.leverx.supplierbootapp.repository;

import com.leverx.supplierbootapp.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
