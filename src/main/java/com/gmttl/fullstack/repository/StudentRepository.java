package com.gmttl.fullstack.repository;

import com.gmttl.fullstack.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {

    Student findStudentByEmail(String email);

}
