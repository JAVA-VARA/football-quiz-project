package com.example.footballquizproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaAuditing
@EnableScheduling
@EnableCaching
@SpringBootApplication
@EnableAsync
public class FootballQuizProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballQuizProjectApplication.class, args);
    }

}
