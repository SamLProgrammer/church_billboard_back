package com.example.churchbillboard2.configs;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    //     CorsConfiguration configuration = new CorsConfiguration();
    //     configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Add the origin of your React app
    //     configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
    //     configuration.setAllowCredentials(true); // Allow credentials (e.g., cookies)
    //     // configuration.addAllowedHeader("*"); // You can adjust this to only allow specific headers if needed
    //     configuration.addAllowedHeader("sessionId");
    //     configuration.addAllowedHeader("CustomAuth");
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", configuration);

    //     return source;
    // }
}