package com.example.springboot_week04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.springboot_week04.entity.Student;


@Configuration
public class StudentConfig {

    @Bean
    public Student student() {
        Student student = new Student();
        student.setId(1L);
        student.setName("zxyang");
        return student;
    }
}