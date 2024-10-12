package com.tp3arquitecturasweb.springbootapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="EstudianteCarrera")
@Getter @Setter
public class StudentCareer {
    @EmbeddedId
    private StudentCareerPK id;

    @ManyToOne
    @MapsId("idCareer")
    @JoinColumn(name = "id_carrera")
    private Career career;

    @ManyToOne
    @MapsId("idStudent")
    @JoinColumn(name = "id_estudiante")
    private Student student;

    @Column(name = "fecha_inscripcion")
    private LocalDate inscriptionDate;

    @Column(name = "fecha_graduacion")
    private LocalDate graduationDate;

    public StudentCareer() {}

    public StudentCareer(Student student, Career career) {
        this.id = new StudentCareerPK(student.getIdStudent(), career.getIdCareer());
        this.student = student;
        this.career = career;
        this.inscriptionDate = LocalDate.now();
        this.graduationDate = null;
    }

    public boolean isGraduated() {
        return (this.graduationDate == null) ? false : true;
    }

    public Period getAntiquity() {
        LocalDate now = LocalDate.now();
        return Period.between(inscriptionDate, now);
    }
}
