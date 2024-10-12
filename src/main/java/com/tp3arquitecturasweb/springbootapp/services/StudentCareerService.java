package com.tp3arquitecturasweb.springbootapp.services;

import com.tp3arquitecturasweb.springbootapp.models.Career;
import com.tp3arquitecturasweb.springbootapp.models.Student;
import com.tp3arquitecturasweb.springbootapp.models.StudentCareer;
import com.tp3arquitecturasweb.springbootapp.models.StudentCareerPK;
import com.tp3arquitecturasweb.springbootapp.repository.CareerRepository;
import com.tp3arquitecturasweb.springbootapp.repository.StudentCareerRepository;
import com.tp3arquitecturasweb.springbootapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentCareerService {
    @Autowired
    private StudentCareerRepository studentCareerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CareerRepository careerRepository;

    public ResponseEntity<?> registerStudent(Long studentId, Long careerId) {
        if (!studentRepository.existsById(studentId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"The student does not exist.\"}");
        }

        if (!careerRepository.existsById(careerId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"The career does not exist.\"}");
        }

        StudentCareerPK pk = new StudentCareerPK(studentId, careerId);
        if (studentCareerRepository.existsById(pk)) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"The student is already registered.\"}");
        }

        Student student = studentRepository.getReferenceById(studentId);
        Career career = careerRepository.getReferenceById(careerId);

        StudentCareer studentCareer = new StudentCareer(student, career);
        studentCareerRepository.save(studentCareer);

        return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"The student registered successfully.\"}");
    }
}
