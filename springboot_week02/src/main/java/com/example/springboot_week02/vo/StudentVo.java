package com.example.springboot_week02.vo;

import com.example.springboot_week02.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class StudentVo {
    private Long id;
    private String name;
    private String mobile;
    private GenderEnum gender;
    private Boolean enabled;
    private LocalDateTime createTime;
}
