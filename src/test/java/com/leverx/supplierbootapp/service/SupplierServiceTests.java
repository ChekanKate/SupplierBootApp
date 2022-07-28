package com.leverx.supplierbootapp.service;

import com.leverx.supplierbootapp.SupplierBootAppApplication;
import com.leverx.supplierbootapp.entity.*;
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

    @Test
    public void deleteSupplierTest() {
        Supplier supplier = supplierService.findSupplierById(203L);
        supplierService.deleteSupplierById(supplier.getId());

        Supplier deletedSupplier = supplierService.findSupplierById(203L);
        assertThat(deletedSupplier).isNull();
    }

    @Test
    public void getAddressFromSupplierTest() {
        Supplier actual = supplierService.findSupplierById(202L);
        assertEquals(createAddress(), actual.getAddress());
    }

    @Test
    public void getOrdersFromSupplierTest() {
        Supplier actual = supplierService.findSupplierById(202L);
        Set<Order> orders = createOrderSet();
        assertThat(actual.getOrders()).isNotEmpty();
        assertEquals(orders.size(), actual.getOrders().size());
    }

    @Test
    public void getSupplierByIdTest(){
        Supplier actual = supplierService.findSupplierById(202L);
        assertThat(actual).isNotNull();
        assertEquals(202L, actual.getId());
    }

    @Test
    public void getProductsFromSupplierTest(){
        Supplier actual = supplierService.findSupplierById(202L);
        Order actualOrder = actual.getOrders().stream().findFirst().get();
        assertThat(actualOrder.getProducts()).isNotEmpty();
        assertEquals(createProductSet(), actualOrder.getProducts());
    }

    @Test
    public void getRecipientsFromSupplierTest() {
        Supplier actual = supplierService.findSupplierById(202L);
        assertThat(actual.getRecipients()).isNotEmpty();
        assertEquals(createRecipientSet().size(), actual.getRecipients().size());
    }

    @Test
    public void findAllTest(){
        List<Supplier> suppliers = supplierService.findAllSuppliers();
        assertThat(suppliers.size()).isEqualTo(4);
    }

    public Address createAddress() {
        return new Address(102L, "Poland", "Wroclaw", "Maja", 23, 202L);
    }

    public Set<Order> createOrderSet() {
        Order order1 = new Order(403L, "Order 1 to SoftServe", 120000.0, 202L, Collections.emptySet());
        Set<Order> orders = new HashSet<>();
        orders.add(order1);
        return orders;
    }

    public Set<Product> createProductSet() {
        Product product1 = new Product(504L, "Product 1 to Order1 to SoftServe", 40000, 403L);
        Product product2 = new Product(505L, "Product 2 to Order1 to SoftServe", 80000, 403L);
        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        return products;
    }

    public Set<Recipient> createRecipientSet() {
        Recipient recipient1 = new Recipient(301L, "Candy Shop", Collections.emptySet());
        Recipient recipient2 = new Recipient(303L, "School", Collections.emptySet());
        Set<Recipient> recipients = new HashSet<>();
        recipients.add(recipient2);
        recipients.add(recipient1);
        return recipients;
    }

}
