package com.github.jizumer.rps.dashboard.stats.domain;

import java.util.Objects;

public class Stats {
    private final ResultCounter player1Wins;
    private final ResultCounter player2Wins;
    private final ResultCounter draws;

    public Stats(ResultCounter player1Wins, ResultCounter player2Wins, ResultCounter draws) {
        if (player1Wins == null
                || player2Wins == null
                || draws == null) {
            throw new IllegalArgumentException("All counters must be non-null");
        }
        this.player1Wins = player1Wins;
        this.player2Wins = player2Wins;
        this.draws = draws;
    }

    public long getPlayer1Wins() {
        return player1Wins.getValue();
    }

    public long getPlayer2Wins() {
        return player2Wins.getValue();
    }

    public long getDraws() {
        return draws.getValue();
    }

    public long getTotalRounds() {
        return player1Wins.getValue()
                + player2Wins.getValue()
                + draws.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return player1Wins.equals(stats.player1Wins) &&
                player2Wins.equals(stats.player2Wins) &&
                draws.equals(stats.draws);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1Wins, player2Wins, draws);
    }
}
