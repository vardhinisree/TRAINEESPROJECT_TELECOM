package com.telecom.Wezen.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    /**
     * Configures the OpenAPI documentation for the Telecom API.
     * This will be accessible at /swagger-ui/index.html
     */
    @Bean
    public OpenAPI telecomOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Telecom API Documentation")
                        .description("API endpoints for Telecom Project — Users, Plans, Recharges, Complaints, Usage")
                        .version("1.0.0"));
    }
}
