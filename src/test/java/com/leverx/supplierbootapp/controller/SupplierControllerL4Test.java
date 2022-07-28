package com.leverx.supplierbootapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leverx.supplierbootapp.SupplierBootAppApplication;
import com.leverx.supplierbootapp.dto.SupplierDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = SupplierBootAppApplication.class)
@AutoConfigureMockMvc
@WebAppConfiguration
@ActiveProfiles("test")
public class SupplierControllerL4Test {

    @Autowired
    private MockMvc mockMvc;

    private String obtainAccessToken(String username, String password) throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "leverx");
        params.add("username", username);
        params.add("password", password);

        ResultActions result = mockMvc.perform(post("/oauth/token")
                        .params(params)
                        .with(httpBasic("leverx","leverx-secret-key"))
                        .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Test
    @DisplayName("Get supplier by id (authenticated user with role USER))")
    public void getSupplierByIdTest1() throws Exception {
        String accessToken = obtainAccessToken("ivan", "ivan");
        mockMvc.perform(get("/v4/suppliers/{id}", 201)
                        .header("Authorization", "Bearer " + accessToken)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(201))
                .andExpect(jsonPath("$.name").value("LeverX"))
                .andExpect(jsonPath("$._links").exists());
    }

    @Test
    @DisplayName("Get supplier by id (unauthorized user))")
    public void getSupplierByIdTest2() throws Exception {
        mockMvc.perform(get("/v4/suppliers/{id}", 201).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Get all suppliers (authenticated user with role USER))")
    public void getAllSuppliersTest1() throws Exception {
        String accessToken = obtainAccessToken("ivan", "ivan");
        mockMvc.perform(get("/v4/suppliers")
                        .header("Authorization", "Bearer " + accessToken)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$._embedded.supplierDTOList").exists())
                .andExpect(jsonPath("$._embedded.supplierDTOList[*].id").isNotEmpty());
    }

    @Test
    @DisplayName("Get all suppliers (unauthorized user))")
    public void getAllSuppliersTest2() throws Exception {
        mockMvc.perform(get("/v4/suppliers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Create new supplier (authenticated user with role USER))")
    public void createSupplierTest1() throws Exception {
        String accessToken = obtainAccessToken("ivan", "ivan");
        mockMvc.perform(post("/v4/suppliers")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(asJsonString(new SupplierDTO("testSupplier")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    @DisplayName("Create new supplier (unauthorized user))")
    public void createSupplierTest2() throws Exception {
        mockMvc.perform(post("/v4/suppliers"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Update supplier (authenticated user with role USER))")
    public void updateSupplierTest1() throws Exception {
        String accessToken = obtainAccessToken("ivan", "ivan");
        mockMvc.perform(put("/v4/suppliers")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(asJsonString(new SupplierDTO(204L, "UpdatedSupplier")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("UpdatedSupplier"));
    }

    @Test
    @DisplayName("Update supplier (unauthorized user))")
    public void updateSupplierTest2() throws Exception {
        mockMvc.perform(put("/v4/suppliers"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Delete supplier (authenticated user with role ADMIN))")
    public void deleteSupplierTest1() throws Exception {
        String accessToken = obtainAccessToken("kateryna", "kateryna");
        mockMvc.perform(delete("/v4/suppliers/{id}", 203)
                        .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Delete supplier (authenticated user with role USER))")
    public void deleteSupplierTest2() throws Exception {
        String accessToken = obtainAccessToken("ivan", "ivan");
        mockMvc.perform(delete("/v4/suppliers/{id}", 203)
                        .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("Delete supplier (unauthorized user))")
    public void deleteSupplierTest3() throws Exception {
        mockMvc.perform(delete("/v4/suppliers/{id}", 203))
                .andExpect(status().isUnauthorized());
    }

    public static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
