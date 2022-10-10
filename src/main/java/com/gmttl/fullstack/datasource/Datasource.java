package com.gmttl.fullstack.datasource;

import com.gmttl.fullstack.entity.Student;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;


@Configuration
public class Datasource {

    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder.
                create().
                type(HikariDataSource.class).
                build();
    }

    @Bean
    BeforeConvertCallback<Student> beforeConvertCallback() {
        // https://spring.io/blog/2021/09/09/spring-data-jdbc-how-to-use-custom-id-generation
        return (student) -> {
            if (student.getStudentId() == null) {
                return new Student(
                        UUID.randomUUID(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getEmail(),
                        student.getGender());
            }
            return student;
        };
    }
}
