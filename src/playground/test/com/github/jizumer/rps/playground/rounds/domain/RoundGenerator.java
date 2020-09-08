package com.github.jizumer.rps.playground.rounds.domain;

import com.github.jizumer.rps.playground.rounds.application.RoundPlayerRequest;

import java.util.UUID;

public final class RoundGenerator {
    public static Round toEntity(RoundPlayerRequest request) {

        //There is a rule that states that player 1 will play randomly, and player 2 will always play rock
        return new Round(new RoundId(request.getId()),
                new RandomPlayer(UUID.randomUUID().toString()),
                new AlwaysRockPlayer(UUID.randomUUID().toString()));
    }
}
