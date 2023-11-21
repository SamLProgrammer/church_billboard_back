package com.example.churchbillboard2.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("https://app.mysqlconnectornoderaged.com", "http://localhost:3000")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .exposedHeaders("CustomAuth", "Content-Type", "Accept",
                        "Authorization",
                        "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(true);

    }
}