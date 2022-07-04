package com.leverx.supplierbootapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leverx.supplierbootapp.SupplierBootAppApplication;
import com.leverx.supplierbootapp.dto.SupplierDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = SupplierBootAppApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SupplierControllerL4Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSupplierByIdTest() throws Exception {
        mockMvc.perform(get("/v4/suppliers/{id}", 201).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(201))
                .andExpect(jsonPath("$.name").value("LeverX"));
    }

    @Test
    public void getAllSuppliersTest() throws Exception {
        mockMvc.perform(get("/v4/suppliers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$._embedded.supplierDTOList").exists())
                .andExpect(jsonPath("$._embedded.supplierDTOList[*].id").isNotEmpty());

    }

    @Test
    public void createSupplierTest() throws Exception {
        mockMvc.perform(post("/v4/suppliers")
                .content(asJsonString(new SupplierDTO("testSupplier")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void updateSupplierTest() throws Exception {
        mockMvc.perform(put("/v4/suppliers")
                .content(asJsonString(new SupplierDTO(204L, "UpdatedSupplier")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("UpdatedSupplier"));
    }

    @Test
    public void deleteSupplierTest() throws Exception {
        mockMvc.perform(delete("/v4/suppliers/{id}", 203))
                .andExpect(status().isNoContent());
    }

    public static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
