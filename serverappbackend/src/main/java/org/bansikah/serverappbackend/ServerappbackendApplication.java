package org.bansikah.serverappbackend;

import org.apache.catalina.filters.CorsFilter;
import org.bansikah.serverappbackend.enumeration.Status;
import org.bansikah.serverappbackend.model.Server;
import org.bansikah.serverappbackend.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;
import static org.bansikah.serverappbackend.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerappbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerappbackendApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepo serverRepo) {
        return args -> {
            serverRepo.save(new Server(1L,"192.168.10.0", "Ubuntu Linux", "16 GB",
                    "Personal PC", "http://localhost/8081/server/image/server1.png", Status.SERVER_UP));

            serverRepo.save(new Server(2L,"192.168.10.1", "Ubuntu Linux", "16 GB",
                    "Workstation", "http://localhost/8081/server/image/server5.png", Status.SERVER_UP));

            serverRepo.save(new Server(3L,"192.168.10.2", "CentOS", "8 GB",
                    "Database Server", "http://localhost/8081/server/image/server3.png", Status.SERVER_UP));

            serverRepo.save(new Server(4L,"192.168.10.3", "Windows Server", "32 GB",
                    "File Server", "http://localhost/8081/server/image/server4.png", Status.SERVER_UP));
        };
    }
/*
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource urlBasedCorsConfiguration = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin(Array.asList("http://localhost:3000", "http://localhost:4200"));
        corsConfiguration.addAllowedHeader(Array.asList("Origin", "Access-Control-Allow-Origin", "Content-Type"
                ,"Accept","Jwt-Token","Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
                "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Array.asList("Origin", "Access-Control-Allow-Origin", "Content-Type"
                ,"Accept","Jwt-Token","Authorization",
                "Access-Control-Allow-Origin", "Filename"));
        corsConfiguration.setAllowedMethods(Array.asList("GET", "PUT","POST","DELETE","OPTIONS","PATCH"));
        urlBasedCorsConfiguration.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter();
    }*/

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);

        List<String> allowedOrigins = new ArrayList<>();
        allowedOrigins.add("http://localhost:3000");
        allowedOrigins.add("http://localhost:4200");
        corsConfiguration.setAllowedOrigins(allowedOrigins);

        List<String> allowedHeaders = new ArrayList<>();
        allowedHeaders.add("Origin");
        allowedHeaders.add("Access-Control-Allow-Origin");
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("Accept");
        allowedHeaders.add("Jwt-Token");
        allowedHeaders.add("Authorization");
        allowedHeaders.add("Origin, Accept");
        allowedHeaders.add("X-Requested-With");
        allowedHeaders.add("Access-Control-Request-Method");
        allowedHeaders.add("Access-Control-Request-Headers");
        corsConfiguration.setAllowedHeaders(allowedHeaders);

        List<String> exposedHeaders = new ArrayList<>();
        exposedHeaders.add("Origin");
        exposedHeaders.add("Access-Control-Allow-Origin");
        exposedHeaders.add("Content-Type");
        exposedHeaders.add("Accept");
        exposedHeaders.add("Jwt-Token");
        exposedHeaders.add("Authorization");
        exposedHeaders.add("Access-Control-Allow-Origin");
        exposedHeaders.add("Filename");
        corsConfiguration.setExposedHeaders(exposedHeaders);

        List<String> allowedMethods = new ArrayList<>();
        allowedMethods.add("GET");
        allowedMethods.add("PUT");
        allowedMethods.add("POST");
        allowedMethods.add("DELETE");
        allowedMethods.add("OPTIONS");
        allowedMethods.add("PATCH");
        corsConfiguration.setAllowedMethods(allowedMethods);

        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter();
    }
}
