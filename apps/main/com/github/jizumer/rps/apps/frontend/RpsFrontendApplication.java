package com.github.jizumer.rps.apps.frontend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {
        "com.github.jizumer.rps.core",//Necessary to boot up shared infrastructures, like command bus
        "com.github.jizumer.rps.playground",
        "com.github.jizumer.rps.dashboard",
        "com.github.jizumer.rps.apps.frontend"}
)
public class RpsFrontendApplication {

}
