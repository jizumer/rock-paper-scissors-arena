package com.github.jizumer.rps.apps.frontend.controller.health;

import com.github.jizumer.rps.apps.ApiInfrastructureTest;
import org.junit.jupiter.api.Test;

final class BackendFrontendHealthGetControllerTest extends ApiInfrastructureTest {


    @Test
    void healthControllerShouldReturnOkResponseJson() throws Exception {
        this.assertResponse("/frontend-health", 200, "{'frontend-status': 'ok'}");
    }

}