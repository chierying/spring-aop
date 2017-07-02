package com.example.demo;

import com.example.demo.requestlimit.annotation.EnableRequestLimit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRequestLimit
@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }
}
