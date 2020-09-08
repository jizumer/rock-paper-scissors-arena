package com.github.jizumer.rps.core.infrastructure;

import com.github.jizumer.rps.apps.Boot;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Boot.class)
@SpringBootTest
public abstract class InfrastructureTestCase {

}
