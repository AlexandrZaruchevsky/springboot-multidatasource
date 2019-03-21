package ru.zaa.springboot.multidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Appliccation {
    public static void main(String[] args) {
        SpringApplication.run(Appliccation.class, "--debug");
    }
}
