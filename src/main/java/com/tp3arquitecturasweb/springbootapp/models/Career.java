package com.tp3arquitecturasweb.springbootapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Carrera")
@Getter @Setter
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private Long idCareer;

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
}
