package com.tp3arquitecturasweb.springbootapp.repository;

import com.tp3arquitecturasweb.springbootapp.dto.*;
import com.tp3arquitecturasweb.springbootapp.dto.ReportDTO;
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

    @Query(value = """
            SELECT c.id_carrera, 
                   c.nombre, 
                   ec.anio, 
                   ec.cant_inscriptos, 
                   ec.cant_recibidos
            FROM carrera c
            LEFT JOIN (
                -- Subconsulta para obtener la cantidad de inscriptos por carrera y año
                SELECT ec.id_carrera, 
                       COUNT(ec.id_carrera) AS cant_inscriptos, 
                       0 AS cant_recibidos, 
                       EXTRACT(YEAR FROM ec.fecha_inscripcion) AS anio
                FROM estudiante_carrera ec
                WHERE ec.fecha_inscripcion IS NOT NULL
                GROUP BY ec.id_carrera, EXTRACT(YEAR FROM ec.fecha_inscripcion)
                
                UNION ALL
                
                -- Subconsulta para obtener la cantidad de graduados por carrera y año
                SELECT ec.id_carrera, 
                       0 AS cant_inscriptos, 
                       COUNT(ec.id_carrera) AS cant_recibidos, 
                       EXTRACT(YEAR FROM ec.fecha_graduacion) AS anio
                FROM estudiante_carrera ec
                WHERE ec.fecha_graduacion IS NOT NULL
                GROUP BY ec.id_carrera, EXTRACT(YEAR FROM ec.fecha_graduacion)
                
            ) ec ON ec.id_carrera = c.id_carrera
            ORDER BY c.nombre, ec.anio
            """, nativeQuery = true)
    List<Object[]> getReports();


}
