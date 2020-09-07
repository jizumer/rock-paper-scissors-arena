package com.github.jizumer.rps.core.infrastructure;

import com.github.jizumer.rps.apps.Boot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Boot.class)
@SpringBootTest
public class InfrastructureTestCase {
    @Test
    void contextLoads() {
    }
}
