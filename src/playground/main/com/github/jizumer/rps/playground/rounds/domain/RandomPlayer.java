package com.github.jizumer.rps.playground.rounds.domain;

import java.util.Objects;
import java.util.Random;

public class RandomPlayer implements Player {

    private final String id;

    public RandomPlayer(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public Move play() {
        return Move.values()[new Random().nextInt(2)];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
        //Two players of the same class, are  considered exactly the same
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
