package com.tp3arquitecturasweb.springbootapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.HashSet;



@Entity
@Table(name="Estudiante")
@Getter @Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idStudent;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
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
    //to do: ver como hacer para que responda con 400 y estos mensajes.
    //@NotBlank(message = "studentNumber is mandatory")
    //@NotNull(message = "studentNumber is mandatory")
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

    @Override
    public String toString() {
        return "Estudiante{" +
                "ciudad='" + city + '\'' +
                ", nombre='" + firstName + '\'' +
                ", apellido='" + lastName + '\'' +
                ", edad=" + age +
                ", genero=" + gender +
                ", nro_documento=" + documentNumber +
                ", nro_libreta_universitaria=" + studentNumber +
                ", id_estudiante=" + idStudent +
                '}';
    }
}
