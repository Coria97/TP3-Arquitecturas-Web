package com.tp3arquitecturasweb.springbootapp.services;

import com.tp3arquitecturasweb.springbootapp.models.Student;
import com.tp3arquitecturasweb.springbootapp.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student addStudent(Student student) throws Exception {
        try {
            return studentRepository.save(student);
        }
        catch (Exception e) {
            throw new Exception("Error when trying to register the student.");
        }
    }

    public List<Student> getAllStudents(Sort sort) {
        try{
            return studentRepository.findAll(sort);
        }
        catch (Exception e) {
            throw new RuntimeException("Error retrieving the list of students");
        }
    }
}
