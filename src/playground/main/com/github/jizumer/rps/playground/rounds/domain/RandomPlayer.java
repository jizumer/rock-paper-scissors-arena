package com.github.jizumer.rps.playground.rounds.domain;

import java.util.Objects;
import java.util.Random;

public class RandomPlayer implements Player {

    private final PlayerId id;

    public RandomPlayer(PlayerId id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id.value();
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
