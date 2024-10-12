package com.tp3arquitecturasweb.springbootapp.controllers;

import com.tp3arquitecturasweb.springbootapp.repository.CareerRepository;
import com.tp3arquitecturasweb.springbootapp.services.StudentCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/careers")
public class CareerController {

    @Autowired
    private StudentCareerService studentCareerService;

    @PostMapping("/{careerId}/register/{studentId}")
    public ResponseEntity<?> registerStudent(@PathVariable("careerId") Long careerId, @PathVariable("studentId") Long studentId){
        return studentCareerService.registerStudent(studentId, careerId);
    }

}
