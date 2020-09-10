package com.github.jizumer.rps.apps;

import com.github.jizumer.rps.apps.backend.RpsBackendApplication;
import com.github.jizumer.rps.apps.frontend.RpsFrontendApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Map;

public class Boot {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("Expected one argument: the app to run.");
        }
        Map<String, Class<?>> supportedApplications = Map.of("backend", RpsBackendApplication.class,
                "frontend", RpsFrontendApplication.class);
        Class<?> applicationToRun =
                supportedApplications.get(args[0]);
        if (applicationToRun == null) {
            throw new RuntimeException(String.format("Received argument %s does not correspond to a supported class %s.",
                    args[0],
                    supportedApplications.keySet()));
        }

        SpringApplication.run(applicationToRun);
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
