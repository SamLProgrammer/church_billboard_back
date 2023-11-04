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
        .allowedOrigins("http://181.131.99.9:3000", "http://168.102.68.10:3000", "http://localhost:3000", "http://195.35.37.48:3000")
        .allowedMethods("PUT", "DELETE", "POST", "GET", "OPTIONS")
        .allowedHeaders("Accept", "CustomAuth", "Authorization", "Access-Control-Allow-Credentials", "Content-Type", "credentials", "Origin", "Access-Control-Allow-Origin")
        .allowCredentials(true);

    }
}
// .allowedOriginPatterns("*")
// .allowedOrigins("http://181.131.99.9:3000", "http://localhost:3000", "http://186.102.8.10")
// .allowedMethods("PUT", "DELETE", "POST", "GET", "OPTIONS")
// .allowedHeaders("CustomAuth", "Authorization", "header3", "Origin", "Access-Control-Allow-Origin", "Content-Type",
// "Accept", "Origin, Accept", "X-Requested-With",
// "Access-Control-Request-Method", "Access-Control-Request-Headers")
// .exposedHeaders("CustomAuth", "Origin", "Content-Type", "Accept", "Authorization",
// "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
// .allowCredentials(true);