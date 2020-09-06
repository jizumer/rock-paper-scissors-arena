package com.github.jizumer.rps.apps.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@SpringBootApplication
@ComponentScan(value = {"com.github.jizumer.rps.core",
        "com.github.jizumer.rps.playground",
        "com.github.jizumer.rps.dashboard",
        "com.github.jizumer.rps.apps.backend"}
)
public class RpsBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        //TODO: Not yet defined
        return new HashMap<>();
    }
}