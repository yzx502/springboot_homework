package com.example.springboot_week02.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentUpdateDTO {
    private String name;
    private String mobile;
    private String avatar;
}
