package com.example.eshopweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/*
Anotace @SpringBootApplication v sobe schovava:
@Configuration
@ComponentScan
@EnableAutoConfiguration
*/
@EnableAsync
@EnableScheduling
@EnableCaching
@SpringBootApplication
public class EshopWebApplication {

    private static final Logger log = LoggerFactory.getLogger(EshopWebApplication.class);

    public static void main(String[] args) {
        // args se da vyuzit:
        // java -jar target/app.jar --server.port=9090
        SpringApplication.run(EshopWebApplication.class, args);
    }

//    @Scheduled(fixedDelay = 5_000)
//    public void run() {
//        log.info("running");
//    }

}
