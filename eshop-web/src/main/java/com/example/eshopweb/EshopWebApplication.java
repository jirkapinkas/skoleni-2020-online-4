package com.example.eshopweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/*
Anotace @SpringBootApplication v sobe schovava:
@Configuration
@ComponentScan
@EnableAutoConfiguration
*/
@EnableAsync
@SpringBootApplication
public class EshopWebApplication {

    public static void main(String[] args) {
        // args se da vyuzit:
        // java -jar target/app.jar --server.port=9090
        SpringApplication.run(EshopWebApplication.class, args);
    }

}
