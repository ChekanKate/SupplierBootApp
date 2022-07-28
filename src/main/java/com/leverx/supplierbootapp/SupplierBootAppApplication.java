package com.leverx.supplierbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.leverx.supplierbootapp.repository")
@EnableResourceServer
@EnableAuthorizationServer
public class SupplierBootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierBootAppApplication.class, args);
    }

}
