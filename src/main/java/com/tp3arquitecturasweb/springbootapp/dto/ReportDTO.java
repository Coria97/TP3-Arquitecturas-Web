package com.tp3arquitecturasweb.springbootapp.dto;

import lombok.Data;

@Data
public class ReportDTO {
    private Integer idCareer;
    private String name;
    private int year;
    private int inscriptionAmount;
    private int graduatesAmount;

    public ReportDTO(Integer idCareer, String name, int year, int inscriptionAmount, int graduatesAmount) {
        this.idCareer = idCareer;
        this.name = name;
        this.year = year;
        this.inscriptionAmount = inscriptionAmount;
        this.graduatesAmount = graduatesAmount;
    }


}
