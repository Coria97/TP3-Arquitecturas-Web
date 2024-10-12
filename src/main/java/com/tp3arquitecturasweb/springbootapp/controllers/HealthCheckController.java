package com.tp3arquitecturasweb.springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;


@RestController
public class HealthCheckController {

    @GetMapping("api/v1/health_check")
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "The App is up");
        return response;
    }
}
