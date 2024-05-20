package com.sami.sami_app.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = " DOCUMENTATION OF SAMI - Servicio Ambulatorio Médico inmediato.",
        version = "2.0",
        description = "ES==> SAMI - Es una aplicación para la gestión de emergencias médicas, diseñada para optimizar la coordinación de servicios de ambulancias para reducir tiempos de espera y aumentar la eficiencia operativa al momento de solicitar un servicio de ambulancias, proporcionando así un servicio rápido, preciso y confiable en situaciones críticas o en casos de emergencia.                           EN==> SAMI - Is an application for the management of medical emergencies, designed to optimize the coordination of ambulance services to reduce waiting times and increase operational efficiency when requesting an ambulance service, thus providing a fast, accurate and reliable service in critical situations or in cases of emergency.",
        termsOfService = "http://example.com/terms",
        contact = @Contact(
            name = "SAMI",
            url = "https://alejandro-quiceno-perez.github.io/SAMI_FRONT/index.html",
            email = "samiserviciosambulatorios@gmail.com"
        ),
        license = @License(
            name = "SAMI Version 2.0"
        )
    ),
    security = {
        @SecurityRequirement(name = "Spring Security", scopes = {"read", "write"})
    },
    extensions = {
        @Extension(
            name = "Software Developers",
            properties = {
                @ExtensionProperty(name = "Juan Sebastián Fernández Montoya", value = "https://juansefdz.com/"),
                @ExtensionProperty(name = "Alejandro Quiceno Pérez", value = "https://alejandro-quiceno-perez.github.io/AlejandroQuicenoPerez/"),
                @ExtensionProperty(name = "Ana María Restrepo Quintero", value = "https://anresq.netlify.app/"),
                @ExtensionProperty(name = "Jhonatan Toro Hurtado", value = "https://jhonatantoro.netlify.app/")
                
            }
        )
    }
)

public class OpenApiConfig {
    
}
