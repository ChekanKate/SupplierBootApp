package com.leverx.supplierbootapp;

import com.leverx.supplierbootapp.entity.*;
import com.leverx.supplierbootapp.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = SupplierBootAppApplication.class)
@ActiveProfiles("test")
class SupplierServiceTests {

    @Autowired
    private SupplierService supplierService;

    @Test
    public void saveSupplierTest() {
        Address address = new Address(110L, "Poland", "Wroclaw", "Maja", 23);
        Supplier supplier1 = new Supplier("SupplierName", address, Collections.emptySet(), Collections.emptySet());
        assertThat(supplier1.getId()).isNull();
        Supplier savedSupplier = supplierService.saveOrUpdateSupplier(supplier1);
        assertThat(savedSupplier.getId()).isNotNull();
    }

//    @Test
//    public void updateSupplierTest() {
//        Supplier supplier = supplierService.findSupplierById(201L);
//        supplier.setName("LeverX Group");
//
//        supplierService.saveOrUpdateSupplier(supplier);
//        Supplier updatedSupplier = supplierService.findSupplierById(201L);
//        assertThat(updatedSupplier.getName()).isEqualTo("LeverX Group");
//    }

    @Test
    public void deleteSupplierTest() {
        Supplier supplier = supplierService.findSupplierById(203L);
        supplierService.deleteSupplierById(supplier.getId());

        Supplier deletedSupplier = supplierService.findSupplierById(203L);
        assertThat(deletedSupplier).isNull();
    }

    @Test
    public void findByIdTest() {
        Product product1 = new Product(504L, "Product 1 to Order1 to SoftServe", 40000, 403L);
        Product product2 = new Product(505L, "Product 2 to Order1 to SoftServe", 80000, 403L);
        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        Order order1 = new Order(403L, "Order 1 to SoftServe", 120000.0, 202L, products);
        Set<Order> orders = new HashSet<>();
        orders.add(order1);
        Address address1 = new Address(102L, "Poland", "Wroclaw", "Maja", 23, 202L);
        Address address2 = new Address(105L, "Ukraine", "Mukachevo", "Petefi", 108, 303L);
        Address address3 = new Address(103L, "UK", "London", "Some street", 34, 301L);
        Set<Address> addresses1 = new HashSet<>();
        addresses1.add(address1);
        Set<Address> addresses2 = new HashSet<>();
        addresses2.add(address2);
        Set<Address> addresses3 = new HashSet<>();
        addresses3.add(address3);
        Recipient recipient1 = new Recipient(301L, "Candy Shop", addresses3);
        Recipient recipient2 = new Recipient(303L, "School", addresses2);
        Set<Recipient> recipients = new HashSet<>();
        recipients.add(recipient2);
        recipients.add(recipient1);
        Supplier expectedSupplier = new Supplier(202L, "SoftServe", address1, orders, recipients);
        Supplier actual = supplierService.findSupplierById(202L);
        assertEquals(expectedSupplier, actual);
    }

    @Test
    public void findAllTest(){
        List<Supplier> suppliers = supplierService.findAllSuppliers();
        assertThat(suppliers.size()).isEqualTo(3);
    }



}
