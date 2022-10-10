package com.gmttl.fullstack.controller;


import com.gmttl.fullstack.entity.Student;
import com.gmttl.fullstack.entity.StudentCourse;
import com.gmttl.fullstack.service.StudentCourseService;
import com.gmttl.fullstack.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final StudentCourseService studentCourseService;


    public StudentController(StudentService studentService, StudentCourseService studentCourseService) {
        this.studentService = studentService;
        this.studentCourseService = studentCourseService;
    }


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}/courses")
    public List<StudentCourse> getAllCoursesForStudent(@PathVariable("id") UUID studentId) {
        return studentCourseService.getAllStudentCourses(studentId);
    }

    @PostMapping("/students")
    public void addNewStudent(@RequestBody @Valid Student student) {
        studentService.addNewStudent(student);
    }
}
