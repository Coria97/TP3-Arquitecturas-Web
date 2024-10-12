package com.tp3arquitecturasweb.springbootapp.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Carrera")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private Integer idCareer;

    @Column(name = "nombre" ,unique = true)
    private String name;

    @Column(name = "area")
    private String zone;

    @Column(name = "duracion")
    private Integer duration;

    @OneToMany(mappedBy = "career", fetch = FetchType.LAZY)
    private Set<StudentCareer> students = new HashSet<>();

    public Career() { }

    public Career(String name, String zone, Integer duration) {
        this.name = name;
        this.zone = zone;
        this.duration = duration;
    }

    public Integer getId() {
        return this.idCareer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<StudentCareer> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentCareer> students) {
        this.students = students;
    }
}
