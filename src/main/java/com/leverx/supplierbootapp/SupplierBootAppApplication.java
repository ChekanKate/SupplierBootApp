package com.leverx.supplierbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.leverx.supplierbootapp.repository")
public class SupplierBootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierBootAppApplication.class, args);
    }

}
