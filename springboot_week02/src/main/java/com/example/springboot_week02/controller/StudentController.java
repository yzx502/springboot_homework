package com.example.springboot_week02.controller;
import com.example.springboot_week02.dto.StudentAddTo;
import com.example.springboot_week02.dto.StudentUpdateDTO;
import com.example.springboot_week02.services.StudentService;
import com.example.springboot_week02.vo.StudentVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Resource
    private StudentService studentService;


    @GetMapping("/all")
    public List<StudentVo> getAllStudents()
    {
        return studentService.getAllStudents();
    }


    @GetMapping("/{id}")
    public StudentVo getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }


       @DeleteMapping("/{id}")
               public void deleteStudent(@PathVariable Long id){
studentService.deleteStudent(id);
        }

        @GetMapping()
    public List<StudentVo> getStudentByName(@RequestParam String name)
    {
        return studentService.getStudentByName(name);
    }

    @PostMapping()
    public String addStudent(@RequestBody StudentAddTo studentAddTo)
    {
        studentService.addStudent(studentAddTo);
        return "添加成功";
    }
    @PutMapping()
    public String updateStudent(@PathVariable Long id, @RequestBody StudentUpdateDTO studentUpdateDTO)
    {
        studentService.updateStudent(id, studentUpdateDTO);
        return "修改成功";
    }
    }

