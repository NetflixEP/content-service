package com.polytech.aps.viewvoyage.movie_service.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Content Service",
                description = "Service for saving data about films and serials", version = "1.0.0",
                contact = @Contact(
                        name = "Emelyanov Pavel"
                )
        )
)
public class OpenApiConfiguration {
}
