package com.github.jizumer.rps.playground.stats.domain;

public class StatsGenerator {

    public static Stats buildFromValues(long player1Wins,
                                        long player2Wins,
                                        long draws) {

        return new Stats(
                new ResultCounter(player1Wins),
                new ResultCounter(player2Wins),
                new ResultCounter(draws));
    }
}
