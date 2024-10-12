package com.tp3arquitecturasweb.springbootapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class StudentCareerPK implements Serializable {
    private Long idStudent;

    private Long idCareer;

    public StudentCareerPK() { }

    public StudentCareerPK(Long idStudent, Long idCareer) {
        this.idStudent = idStudent;
        this.idCareer = idCareer;
    }
}
