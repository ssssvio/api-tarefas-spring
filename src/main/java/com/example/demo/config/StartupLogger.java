package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger {

    @Value("${server.port:8080}")
    private int port;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        String baseUrl = "http://localhost:" + port;
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🚀 APLICAÇÃO INICIADA COM SUCESSO!");
        System.out.println("=".repeat(60));
        System.out.println("📍 URL da Aplicação: " + baseUrl);
        System.out.println("📖 Swagger UI: " + baseUrl + "/swagger-ui/index.html");
        System.out.println("=".repeat(60) + "\n");
    }
}