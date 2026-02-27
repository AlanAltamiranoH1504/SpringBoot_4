package com.example.springboot_4_initial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBoot4InitialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot4InitialApplication.class, args);
    }

}
