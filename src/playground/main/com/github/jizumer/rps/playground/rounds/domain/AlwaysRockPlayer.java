package com.github.jizumer.rps.playground.rounds.domain;

public class AlwaysRockPlayer implements Player {

    @Override
    public Move play() {
        return Move.ROCK;
    }
}
