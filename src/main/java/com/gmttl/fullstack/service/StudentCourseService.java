package com.gmttl.fullstack.service;

import com.gmttl.fullstack.entity.StudentCourse;
import com.gmttl.fullstack.repository.StudentCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentCourseService {

    private final StudentCourseRepository repo;

    public StudentCourseService(StudentCourseRepository repo) {
        this.repo = repo;
    }

    public List<StudentCourse> getAllStudentCourses(UUID studentID) {
        return repo.getAllCourses(studentID);
    }
}
