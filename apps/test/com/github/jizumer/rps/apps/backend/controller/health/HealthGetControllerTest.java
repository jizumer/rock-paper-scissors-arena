package com.github.jizumer.rps.apps.backend.controller.health;

import com.github.jizumer.rps.apps.ApiInfrastructureTest;
import org.junit.jupiter.api.Test;


final class HealthGetControllerTest extends ApiInfrastructureTest {


    @Test
    void healthControllerShouldReturnOkResponseJson() throws Exception {
        this.assertResponse("/health", 200, "{'backend-status': 'ok'}");
    }

}