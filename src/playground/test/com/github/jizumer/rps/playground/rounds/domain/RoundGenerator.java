package com.github.jizumer.rps.playground.rounds.domain;

import com.github.jizumer.rps.playground.rounds.application.RoundPlayerRequest;

import java.util.UUID;

public final class RoundGenerator {
    public static Round toEntity(RoundPlayerRequest request) {

        //There is a rule that states that player 1 will play randomly, and player 2 will always play rock
        return new Round(new RoundId(request.getIdRound()),
                new RandomPlayer(new PlayerId(request.getIdUser())),
                new AlwaysRockPlayer(UUID.randomUUID().toString()));
    }
}
