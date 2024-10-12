package com.tp3arquitecturasweb.springbootapp.models;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="Estudiante")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idStudent;

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

    public Integer getId() { return this.idStudent; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) { this.studentNumber = studentNumber; }

    public Set<StudentCareer> getCarreras() { return career; }

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
