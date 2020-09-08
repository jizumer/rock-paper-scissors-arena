package com.github.jizumer.rps.apps.backend.controller.rounds;

import com.github.jizumer.rps.apps.ApiInfrastructureTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

final class RoundPlayControllerTest extends ApiInfrastructureTest {

    @Test
    void shouldCreateANewRoundWhenPlayingIt() throws Exception {
        UUID randomId = UUID.randomUUID();
        assertRequestWithBody(
                "PUT",
                "/rounds/play/" + randomId,
                "{\"idPlayer\": \"player01\"}",
                201
        );
    }
}
