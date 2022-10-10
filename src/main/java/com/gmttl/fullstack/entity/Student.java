package com.gmttl.fullstack.entity;


import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;


public class Student {

    @Id
    private final UUID studentId;

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    @Email
    private final String email;

    @NotNull
    private final Gender gender;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(
              UUID studentId,
              String firstName,
              String lastName,
              String email,
              Gender gender) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
