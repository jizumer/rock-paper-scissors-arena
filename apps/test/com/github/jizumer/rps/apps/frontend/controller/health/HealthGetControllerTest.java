package com.github.jizumer.rps.apps.frontend.controller.health;

import com.github.jizumer.rps.apps.ApiInfrastructureTest;
import org.junit.jupiter.api.Test;

final class HealthGetControllerTest extends ApiInfrastructureTest {


    @Test
    void healthControllerShouldReturnOkResponseJson() throws Exception {
        this.assertResponse("/health", 200, "{'frontend-status': 'ok'}");
    }

}