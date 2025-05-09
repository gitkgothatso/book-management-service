package com.payu.bookmanager.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Book Management API",
                version = "1.0",
                description = "API documentation for Book Management Service"
        )
)
public class SwaggerConfig {
}