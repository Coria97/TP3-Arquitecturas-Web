package com.tp3arquitecturasweb.springbootapp.repository;

import com.tp3arquitecturasweb.springbootapp.dto.CareerWithEnrolledStudentsDTO;
import com.tp3arquitecturasweb.springbootapp.models.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {

    @Query("SELECT new com.tp3arquitecturasweb.springbootapp.dto.CareerWithEnrolledStudentsDTO(c.idCareer, c.name, COUNT(ec)) " +
            "FROM Career c " +
            "JOIN StudentCareer ec ON ec.career.idCareer = c.idCareer " +
            "GROUP BY c.idCareer, c.name " +
            "HAVING COUNT(ec) > 0 " +
            "ORDER BY COUNT(ec) DESC")
    List<CareerWithEnrolledStudentsDTO> findCareersWithEnrolledStudents();
}
