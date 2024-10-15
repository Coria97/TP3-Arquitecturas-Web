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

    public Student findStudentByStudentNumber(Integer studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new RuntimeException("Student not found with student number: " + studentNumber));
    }

    public List<Student> getAllStudentsByGender(char gender) {
        try{
            return studentRepository.findAllByGender(gender);
        }
        catch (Exception e) {
            throw new RuntimeException("Error retrieving the list of students");
        }
    }

    public List<Student> getAllStudentsByCareerAndCity(String city, Long id_career) {
        try {
            return studentRepository.findAllByCareerAndCity(city, id_career);
        }catch (Exception e) {
            throw new RuntimeException("Error retrieving the list of students");
        }
    }
}
