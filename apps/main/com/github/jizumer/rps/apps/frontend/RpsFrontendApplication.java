package com.github.jizumer.rps.apps.frontend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@SpringBootApplication
@ComponentScan(value = {
        "com.github.jizumer.rps.playground",
        "com.github.jizumer.rps.dashboard",
        "com.github.jizumer.rps.apps.frontend"}
)
public class RpsFrontendApplication {
    public static HashMap<String, Class<?>> commands() {
        //TODO: Not yet defined
        return new HashMap<>();
    }
}
