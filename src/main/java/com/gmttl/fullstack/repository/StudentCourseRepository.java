package com.gmttl.fullstack.repository;

import com.gmttl.fullstack.entity.StudentCourse;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, UUID> {

    @Query("select * from student join student_course using (student_id) join course using (course_id) where student_id = :student_id")
    List<StudentCourse> getAllCourses(@Param("student_id")UUID studentID);
}
