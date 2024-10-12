package com.tp3arquitecturasweb.springbootapp.controllers;

import com.tp3arquitecturasweb.springbootapp.models.Student;
import com.tp3arquitecturasweb.springbootapp.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentController( StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping()
    public ResponseEntity<?> newStudent(@Valid @RequestBody Student student) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Error when trying to register the student.\"}");
        }
    }

}
