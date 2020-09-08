package com.github.jizumer.rps.playground.rounds.domain;

import java.util.UUID;

public final class RoundIdGenerator {

    public static RoundId random() {
        return build(UUID.randomUUID().toString());
    }

    public static RoundId generate(String idRound) {
        return build(idRound);
    }

    private static RoundId build(String idRound) {
        return new RoundId(idRound);
    }


}
