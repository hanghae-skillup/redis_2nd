package com.hanghae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("application")
@SpringBootApplication
public class HanghaeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HanghaeServiceApplication.class, args);
    }
}
