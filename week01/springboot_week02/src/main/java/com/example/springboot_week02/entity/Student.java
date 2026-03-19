package com.example.springboot_week02.entity;

import com.example.springboot_week02.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long id;
    private String name;
    private GenderEnum gender;
    private String avatar;
    private Boolean enabled;
    private LocalDate birthday;
    private String mobile;
    private String email;
    private LocalDateTime createTime;
}
