package com.tp3arquitecturasweb.springbootapp.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class StudentCareerPK implements Serializable {
    private Integer idStudent;

    private Integer idCareer;

    public StudentCareerPK() { }

    public StudentCareerPK(Integer idStudent, Integer idCareer) {
        this.idStudent = idStudent;
        this.idCareer = idCareer;
    }
}
