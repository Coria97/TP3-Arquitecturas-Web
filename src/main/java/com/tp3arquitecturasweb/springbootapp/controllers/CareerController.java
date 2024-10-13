package com.tp3arquitecturasweb.springbootapp.controllers;

import com.tp3arquitecturasweb.springbootapp.repository.CareerRepository;
import com.tp3arquitecturasweb.springbootapp.services.StudentCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/careers")
public class CareerController {

    @Autowired
    private StudentCareerService studentCareerService;

    @PostMapping("/{careerId}/register/{studentId}")
    public ResponseEntity<?> registerStudent(@PathVariable("careerId") Long careerId, @PathVariable("studentId") Long studentId) {
        try {
            String result = studentCareerService.registerStudent(studentId, careerId);
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("message", result);
            return ResponseEntity.status(HttpStatus.OK).body(successResponse);
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
