package com.videoclub.services;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing
public class CorsConfig implements WebMvcConfigurer {
	
	@Value("${path.localhost1}")
	String localhost1;

	@Value("${path.localhost2}")
	String localhost2;
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica CORS a todos los endpoints de la API
                .allowedOrigins(localhost1, localhost2) // Orígenes permitidos
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permite todas las cabeceras
                .allowCredentials(true) // Permite credenciales (cookies, tokens de auth, etc.)
                .maxAge(3600); // Tiempo en segundos que la respuesta preflight puede ser cacheados
    }
}