package org.bailey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"org.bailey"})
@EnableJpaRepositories(basePackages = "org.bailey.repository")
@EntityScan(basePackages = "org.bailey.domain.entity")
public class MovieBookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieBookingApplication.class, args);
    }
}