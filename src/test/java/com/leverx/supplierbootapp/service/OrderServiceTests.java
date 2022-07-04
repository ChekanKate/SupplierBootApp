package com.leverx.supplierbootapp.service;

import com.leverx.supplierbootapp.SupplierBootAppApplication;
import com.leverx.supplierbootapp.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SupplierBootAppApplication.class)
@ActiveProfiles("test")
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void testFindById() {
        Order expected = new Order(401L, "Order 1 to LeverX", 30000d, 201L, Collections.emptySet());
        Order actual = orderService.findById(401L);
        assertEquals(expected.getName(), actual.getName());
    }

}
