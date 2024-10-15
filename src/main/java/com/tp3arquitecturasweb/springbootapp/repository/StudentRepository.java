package com.tp3arquitecturasweb.springbootapp.repository;

import com.tp3arquitecturasweb.springbootapp.models.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll(Sort sort);

    Optional<Student> findByStudentNumber(Integer studentNumber);

    @Query("SELECT s FROM Student s WHERE s.gender = :gender")
    List<Student> findAllByGender(char gender);

    @Query("SELECT e " +
            "FROM Student e " +
            "WHERE e.city = :city " +
            "AND e.idStudent IN (SELECT ec.student.idStudent " +
            "             FROM StudentCareer ec " +
            "             JOIN ec.career c " +
            "             WHERE c.idCareer = :id_career)")
    List<Student> findAllByCareerAndCity(String city, Long id_career);
}
