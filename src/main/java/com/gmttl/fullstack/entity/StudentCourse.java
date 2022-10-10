package com.gmttl.fullstack.entity;


import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

public class StudentCourse {

    @Id
    private final UUID student_id;
    private final UUID course_id;
    private final String course_name;

    private final String description;
    private final String department;
    private final String teacher_name;
    private final LocalDate start_date;
    private final LocalDate end_date;
    private final Integer grade;

    public StudentCourse(
            UUID student_id,
            UUID course_id,
            String course_name,
            String description,
            String department,
            String teacher_name,
            LocalDate start_date,
            LocalDate end_date,
            Integer grade) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.description = description;
        this.department = department;
        this.teacher_name = teacher_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.grade = grade;
    }

    public UUID getStudent_id() {
        return student_id;
    }

    public UUID getCourse_id() {
        return course_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDescription() {
        return description;
    }

    public String getCourse_name() {
        return course_name;
    }
}
