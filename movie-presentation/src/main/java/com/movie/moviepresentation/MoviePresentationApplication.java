package com.movie.moviepresentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.movie.moviepresentation", "com.movie.movieapplication", "com.movie.movieinfrastructures"
})
public class MoviePresentationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviePresentationApplication.class, args);
    }

}
