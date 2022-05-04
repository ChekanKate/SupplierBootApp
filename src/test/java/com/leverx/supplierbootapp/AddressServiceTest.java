package com.leverx.supplierbootapp;

import com.leverx.supplierbootapp.entity.Address;
import com.leverx.supplierbootapp.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SupplierBootAppApplication.class)
@ActiveProfiles("test")
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    void contextLoads() {
    }

    @Test
    public void saveAddressTest () {
        Address address = new Address("Country", "Сity", "Street", 34);
        assertThat(address.getId()).isNull();
        Address savedAddress = addressService.saveOrUpdateAddress(address);
        assertThat(savedAddress.getId()).isNotNull();
    }

    @Test
    public void findByIdTest() {
        Address expected = new Address(105L, "Ukraine", "Mukachevo", "Petefi", 108);
        Address actual = addressService.findById(105L);
        assertEquals(expected, actual);
    }

}
