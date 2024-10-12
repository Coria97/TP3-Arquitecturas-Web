package com.tp3arquitecturasweb.springbootapp.repository;

import com.tp3arquitecturasweb.springbootapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
