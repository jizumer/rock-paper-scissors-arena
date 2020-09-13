package com.github.jizumer.rps.apps.backend.controller.dashboard;

import com.github.jizumer.rps.apps.ApiInfrastructureTest;
import org.junit.jupiter.api.Test;

final class RoundCollectStatsControllerTest extends ApiInfrastructureTest {

    @Test
    void shouldCollectStats() throws Exception {
        assertStatusCode("/stats/",
                200);
    }
}
