package com.marwa.myCatalogue;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MyCatalogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCatalogueApplication.class, args);
    }
}
