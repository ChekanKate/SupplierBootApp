package com.leverx.supplierbootapp.service;

import com.leverx.supplierbootapp.SupplierBootAppApplication;
import com.leverx.supplierbootapp.entity.Recipient;
import com.leverx.supplierbootapp.service.RecipientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SupplierBootAppApplication.class)
@ActiveProfiles("test")
public class RecipientServiceTests {

    @Autowired
    private RecipientService recipientService;

    @Test
    public void getRecipientsById() {
        List<Recipient> recipients = recipientService.getRecipientsBySupplierId(201L);
        assertThat(recipients).isNotNull();
    }

}
