package com.tp3arquitecturasweb.springbootapp.dto;

import lombok.Data;

@Data
public class CareerWithEnrolledStudentsDTO {
    private Long idCareer;
    private String name;
    private Long enrolledCount;

    public CareerWithEnrolledStudentsDTO(Long idCareer, String name, Long enrolledCount) {
        this.idCareer = idCareer;
        this.name = name;
        this.enrolledCount = enrolledCount;
    }
}