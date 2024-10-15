package com.tp3arquitecturasweb.springbootapp.services;

import com.tp3arquitecturasweb.springbootapp.dto.CareerWithEnrolledStudentsDTO;
import com.tp3arquitecturasweb.springbootapp.dto.ReportDTO;
import com.tp3arquitecturasweb.springbootapp.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CareerService {
    @Autowired
    private CareerRepository careerRepository;


    public List<CareerWithEnrolledStudentsDTO> getCareerWithEnrolledStudents() {
        try {
            return careerRepository.findCareersWithEnrolledStudents();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving careers with enrolled students: " + e.getMessage());
        }
    }

    public List<ReportDTO> getReports() {
        try {
            List<Object[]> results = careerRepository.getReports();
            List<ReportDTO> reportList = new ArrayList<>();

            for (Object[] result : results) {

                Integer idCareer = ((Number) result[0]).intValue();
                String name = (String) result[1];
                int year = ((Number) result[2]).intValue();
                int inscriptionAmount = ((Number) result[3]).intValue();
                int graduatesAmount = ((Number) result[4]).intValue();

                boolean found = false;
                for (ReportDTO report : reportList) {
                    if (report.getIdCareer().equals(idCareer) && report.getYear() == year) {
                        report.setInscriptionAmount(report.getInscriptionAmount() + inscriptionAmount);
                        report.setGraduatesAmount(report.getGraduatesAmount() + graduatesAmount);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    reportList.add(new ReportDTO(idCareer, name, year, inscriptionAmount, graduatesAmount));
                }
            }
            return reportList;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving careers with enrolled students: " + e.getMessage());
        }
    }

}
