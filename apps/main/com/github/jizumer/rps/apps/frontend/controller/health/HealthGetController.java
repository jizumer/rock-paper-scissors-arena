package com.github.jizumer.rps.apps.frontend.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthGetController {

    @GetMapping("/health")
    public Map<String, String> index() {
        return Map.of("frontend-status", "ok");
    }
}