package com.example.springboot_week02.services;

import com.example.springboot_week02.enums.GenderEnum;
import com.example.springboot_week02.vo.StudentVo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.springboot_week02.dto.StudentAddTo;
import com.example.springboot_week02.dto.StudentUpdateDTO;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Slf4j
class StudentServiceTest {
    @Resource
    private StudentService studentService;

    @Test
    void getAllStudents() {
        List<StudentVo> allStudents = studentService.getAllStudents();
        allStudents.forEach(studentVO -> log.info("{}", studentVO));
    }

    @Test
    void addStudent() {
        studentService.addStudent(StudentAddTo.builder()
                .name("example")
                .mobile("12345678901")
                .gender(GenderEnum.MALE)
                .avatar("https://example.top/avatar.jpg")
                .birthday(LocalDate.of(1999, 1, 1))
                .build());
        log.info("添加成功");
        List<StudentVo> allStudents = studentService.getAllStudents();
        allStudents.forEach(studentVO -> log.info("{}", studentVO));
    }

    @Test
    void getStudent() {
        StudentVo studentVO = studentService.getStudent(1001L);
        log.info("{}", studentVO);
    }

    @Test
    void getStudentByName() {
        List<StudentVo> studentVO = studentService.getStudentByName("张");
        studentVO.forEach(studentVO1 -> log.info("{}", studentVO1));
    }

    @Test
    void updateStudent() {
        studentService.updateStudent(1001L, StudentUpdateDTO.builder()
                .name("张三111")
                .mobile("12345678901")
                .avatar("https://example.top/new.jpg")
                .build());
        log.info("修改成功");
        StudentVo studentVO = studentService.getStudent(1001L);
        log.info("{}", studentVO);
    }

    @Test
    void deleteStudent() {
        studentService.deleteStudent(1001L);
        log.info("已成功删除");
        List<StudentVo> allStudents = studentService.getAllStudents();
        allStudents.forEach(studentVO -> log.info("{}", studentVO));
    }
}