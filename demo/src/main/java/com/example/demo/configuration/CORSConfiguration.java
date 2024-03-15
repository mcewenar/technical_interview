package com.example.demo.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE")
                .allowedOrigins("http://localhost:4200")
                .allowedHeaders("*");
    }
}

