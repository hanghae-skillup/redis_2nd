package com.pepponechoi.cinema.reservation.service;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.pepponechoi.cinema"})
@EntityScan(basePackages = {"com.pepponechoi.cinema"})
@EnableJpaRepositories(basePackages = {"com.pepponechoi.cinema"})
public class ApiTestConfig {

}
