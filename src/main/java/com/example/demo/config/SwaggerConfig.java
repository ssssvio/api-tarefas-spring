package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Tarefas")
                        .description("API REST para gerenciamento de tarefas desenvolvida com Spring Boot")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Sávio Rezende de Freitas")
                                .email("r.savio@proton.me")));

    }
}