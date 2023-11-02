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
            .allowedOriginPatterns("*")
            // .allowedOrigins("http://181.131.99.9:3000")
            .allowedMethods("PUT", "DELETE", "POST", "GET")

            .allowedHeaders("CustomAuth", "Authorization", "header3", "Origin", "Access-Control-Allow-Origin", "Content-Type",
            "Accept", "Origin, Accept", "X-Requested-With",
            "Access-Control-Request-Method", "Access-Control-Request-Headers")
            // .allowedHeaders("*")

            // .exposedHeaders("CustomAuth", "Origin", "Content-Type", "Accept", "Authorization",
            // "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
            // .allowCredentials(true);
    }
}