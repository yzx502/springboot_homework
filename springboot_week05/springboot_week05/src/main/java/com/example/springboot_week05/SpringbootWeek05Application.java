package com.example.springboot_week05;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboot_week05.mapper")
public class SpringbootWeek05Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeek05Application.class, args);
    }

}

