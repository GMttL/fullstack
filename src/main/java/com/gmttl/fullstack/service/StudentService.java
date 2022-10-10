package com.gmttl.fullstack.service;

import com.gmttl.fullstack.entity.Student;
import com.gmttl.fullstack.exception.APIRequestException;
import com.gmttl.fullstack.repository.StudentRepository;
import org.apache.commons.validator.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return (List<Student>) repo.findAll();
    }


    public Student addNewStudent(Student student) {
        String email = student.getEmail();
        String message = "Not a valid email.";

        if (isValidEmail(email)) {
            if (repo.findStudentByEmail(email) == null) {
                return repo.save(student);
            }
            message = "Email already registered.";
        }

        throw new APIRequestException(message);
    }

    /**
     *
     * @param email
     * @return True/False email is valid according to https://commons.apache.org/proper/commons-validator/
     */
    private boolean isValidEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
