package com.tp3arquitecturasweb.springbootapp.services;

import com.tp3arquitecturasweb.springbootapp.dto.CareerWithEnrolledStudentsDTO;
import com.tp3arquitecturasweb.springbootapp.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {
    @Autowired
    private CareerRepository careerRepository;


    public List<CareerWithEnrolledStudentsDTO> getCareerWithEnrolledStudents() {
        try {
            return careerRepository.findCareersWithEnrolledStudents();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving careers with enrolled students: " + e.getMessage());
        }
    }
}
