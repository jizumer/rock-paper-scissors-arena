package com.github.jizumer.rps.playground.rounds.domain;

import java.util.Random;

public class RandomPlayer implements Player {
    @Override
    public Move play() {
        return Move.values()[new Random().nextInt(2)];
    }
}
