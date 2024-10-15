package com.tp3arquitecturasweb.springbootapp.controllers;

import com.tp3arquitecturasweb.springbootapp.models.Student;
import com.tp3arquitecturasweb.springbootapp.repository.StudentRepository;
import com.tp3arquitecturasweb.springbootapp.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public ResponseEntity<?> newStudent(@Valid @RequestBody Student student) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
        }
        catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllStudents(@RequestParam String param, @RequestParam(defaultValue = "asc") String order) {
        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, param);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents(sort));
        }
        catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/number/{studentNumber}")
    public ResponseEntity<?> getStudentByStudentNumber(@PathVariable Integer studentNumber) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentByStudentNumber(studentNumber));
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<?> getAllStudentsByGender(@PathVariable char gender) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudentsByGender(gender));
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/career/{id_career}")
    public ResponseEntity<?> getAllStudentsByCareerAndCity(@RequestParam String city, @PathVariable Long id_career) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudentsByCareerAndCity(city, id_career));
        }catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
