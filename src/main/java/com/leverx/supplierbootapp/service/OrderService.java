package com.leverx.supplierbootapp.service;

import com.leverx.supplierbootapp.entity.Order;
import com.leverx.supplierbootapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

}
