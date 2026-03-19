package com.example.springboot_week02.dto;
import com.example.springboot_week02.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAddTo {
    private String name;
    private String mobile;
    private GenderEnum gender;
    private String avatar;
    private LocalDate birthday;
}