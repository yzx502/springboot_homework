package com.example.springboot_week02.services;

import com.example.springboot_week02.dto.StudentAddTo;
import com.example.springboot_week02.dto.StudentUpdateDTO;
import com.example.springboot_week02.entity.Student;
import com.example.springboot_week02.enums.GenderEnum;
import com.example.springboot_week02.vo.StudentVo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {
    private static final Map<Long, Student> STUDENT_DATA = new ConcurrentHashMap<>();
    static {
        Student student1 = Student.builder()
                .id(1001L)
                .name("张三")
                .mobile("13888888888")
                .gender(GenderEnum.MALE)
                .avatar("https://example.top/1.png")
                .enabled(true)
                .birthday(LocalDate.of(1990, 1, 1))
                .createTime(LocalDateTime.now())
                .build();
        Student student2 = Student.builder()
                .id(1002L)
                .name("张三丰")
                .mobile("13888888889")
                .gender(GenderEnum.FEMALE)
                .avatar("https://example.top/2.png")
                .enabled(true)
                .birthday(LocalDate.of(1990, 1, 1))
                .createTime(LocalDateTime.now())
                .build();
        STUDENT_DATA.put(student1.getId(), student1);
        STUDENT_DATA.put(student2.getId(), student2);
    }


    public List<StudentVo> getAllStudents() {
        List<StudentVo> list = new ArrayList<>();
        STUDENT_DATA.values().forEach(student -> {
            list.add(com.example.springboot_week02.vo.StudentVo.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .mobile(student.getMobile())
                    .gender(student.getGender())
                    .enabled(student.getEnabled())
                    .createTime(student.getCreateTime())
                    .build());
        });
        return list;
    }


    public void addStudent(StudentAddTo studentAddTo) {
        Student student = Student.builder()
                // id自增，这里使用系统时间
                .id(System.currentTimeMillis())
                .name(studentAddTo.getName())
                .mobile(studentAddTo.getMobile())
                .gender(studentAddTo.getGender())
                .avatar(studentAddTo.getAvatar())
                .enabled(true)
                .birthday(studentAddTo.getBirthday())
                .createTime(LocalDateTime.now())
                .build();
        STUDENT_DATA.put(student.getId(), student);
    }


    public StudentVo getStudent(Long id) {
        Student student = STUDENT_DATA.get(id);
        return com.example.springboot_week02.vo.StudentVo.builder()
                .id(student.getId())
                .name(student.getName())
                .mobile(student.getMobile())
                .gender(student.getGender())
                .createTime(student.getCreateTime())
                .build();
    }


    public List<StudentVo> getStudentByName(String name) {
        List<StudentVo> list = new ArrayList<>();
        STUDENT_DATA.values().forEach(student -> {
            if (student.getName().contains(name)) {
                list.add(com.example.springboot_week02.vo.StudentVo.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .mobile(student.getMobile())
                        .gender(student.getGender())
                        .createTime(student.getCreateTime())
                        .build());
            }
        });
        return list;
    }


    public void updateStudent(Long id, StudentUpdateDTO studentUpdateDTO) {
        Student student = STUDENT_DATA.get(id);
        student.setName(studentUpdateDTO.getName());
        student.setMobile(studentUpdateDTO.getMobile());
        student.setAvatar(studentUpdateDTO.getAvatar());
    }


    public void deleteStudent(Long id) {
        STUDENT_DATA.remove(id);
    }

}
