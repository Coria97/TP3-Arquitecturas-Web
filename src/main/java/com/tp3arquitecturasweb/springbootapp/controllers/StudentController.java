package com.tp3arquitecturasweb.springbootapp.controllers;

import com.tp3arquitecturasweb.springbootapp.models.Student;
import com.tp3arquitecturasweb.springbootapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @PostMapping(value="", produces = "application/json")
    public Student newStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

}
