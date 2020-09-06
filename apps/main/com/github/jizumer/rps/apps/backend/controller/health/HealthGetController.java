package com.github.jizumer.rps.apps.backend.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthGetController {

    @GetMapping("/health")
    public Map<String, String> index() {
        return Map.of("status", "ok");
    }
}