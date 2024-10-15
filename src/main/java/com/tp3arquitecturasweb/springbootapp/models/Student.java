package com.tp3arquitecturasweb.springbootapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;


@Entity
@Table(name="Estudiante")
@Getter @Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idStudent;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<StudentCareer> career = new HashSet<>();

    @Column(name = "ciudad_residencia")
    private String city;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "edad")
    private Integer age;

    @Column(name = "genero")
    private char gender;

    @Column(name = "numero_documento")
    private Integer documentNumber;

    @Column(name = "numero_libreta", unique = true)
    private Integer studentNumber;

    public Student() { }

    public Student(String firstName, String lastName, String city, Integer age, char gender, Integer documentNumber, Integer studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.documentNumber = documentNumber;
        this.studentNumber = studentNumber;
    }

    @JsonProperty("careers")
    public List<String> getCareerNames() {
        return career.stream()
                .map(StudentCareer::getCareerName)
                .collect(Collectors.toList());
    }
}
