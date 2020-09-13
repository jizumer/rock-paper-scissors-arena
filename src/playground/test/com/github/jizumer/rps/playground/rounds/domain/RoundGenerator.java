package com.github.jizumer.rps.playground.rounds.domain;

import com.github.jizumer.rps.playground.rounds.application.RoundPlayerRequest;

import java.util.UUID;

public final class RoundGenerator {
    public static Round toEntity(RoundPlayerRequest request) {

        //There is a rule that states that player 1 will play randomly, and player 2 will always play rock
        //See "Assumptions" section in readme.md file.
        return new Round(new RoundId(request.getIdRound()),
                new RandomPlayer(new PlayerId(request.getIdPlayer())),
                new AlwaysRockPlayer(UUID.randomUUID().toString()));
    }

    public static Round random() {
        return buildFromIds(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

    public static Round buildFromIds(String idRound, String idPlayer) {
        return new Round(RoundIdGenerator.generate(idRound),
                new RandomPlayer(new PlayerId(idPlayer)),
                new AlwaysRockPlayer(UUID.randomUUID().toString()));
    }
}
