package com.tp3arquitecturasweb.springbootapp.services;

import com.tp3arquitecturasweb.springbootapp.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareerService {
    @Autowired
    private CareerRepository careerRepository;

}
