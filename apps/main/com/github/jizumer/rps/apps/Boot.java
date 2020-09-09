package com.github.jizumer.rps.apps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(value = {"com.github.jizumer.rps.core",
        "com.github.jizumer.rps.playground",
        "com.github.jizumer.rps.dashboard",
        "com.github.jizumer.rps.apps"}
)
public class Boot {
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }


    //Next step would be create a command processing system to deploy only the applications indicated in arguments.
    //Those applications are already created, but are not currently being instantiated. Instead, what we do is
    //instantiate the entire context for all applications.
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
