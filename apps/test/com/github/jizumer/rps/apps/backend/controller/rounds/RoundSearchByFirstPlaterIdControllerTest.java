package com.github.jizumer.rps.apps.backend.controller.rounds;

import com.github.jizumer.rps.apps.ApiInfrastructureTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

final class RoundSearchByFirstPlaterIdControllerTest extends ApiInfrastructureTest {

    @Test
    void shouldSearchRoundsByFirstPlayerId() throws Exception {
        UUID randomId = UUID.randomUUID();
        assertStatusCode("/rounds/player/"
                + randomId, 200);
    }
}