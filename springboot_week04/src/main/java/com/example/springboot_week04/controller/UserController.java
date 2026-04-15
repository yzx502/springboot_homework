package com.example.springboot_week04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot_week04.common.Result;
import com.example.springboot_week04.entity.User;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @GetMapping("/info")
    public Result<User> getUserInfo() {
        User user = new User();
        user.setId(1234567890123456789L);
        user.setUsername("springmvc-student");
        user.setCreateTime(LocalDateTime.now());
        return Result.success(user);
    }
}
