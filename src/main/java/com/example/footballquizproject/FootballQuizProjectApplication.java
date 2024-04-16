package com.example.footballquizproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FootballQuizProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballQuizProjectApplication.class, args);
    }

}
