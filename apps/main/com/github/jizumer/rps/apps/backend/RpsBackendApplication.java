package com.github.jizumer.rps.apps.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.github.jizumer.rps.playground",
        "com.github.jizumer.rps.dashboard",
        "com.github.jizumer.rps.apps.backend"}
)
public class RpsBackendApplication {

}
