package com.adminka.practice78;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Practice78Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice78Application.class, args);
    }
}
