package com.example.churchbillboard2.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow CORS for all mappings
            .allowedOrigins("*")  // Allow requests from all origins
            .allowedMethods("*")  // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
            .allowedHeaders("*")  // Allow all headers, including custom headers
            .exposedHeaders("CustomAuth") // Expose any custom headers if needed
            .allowCredentials(true);
    }

}