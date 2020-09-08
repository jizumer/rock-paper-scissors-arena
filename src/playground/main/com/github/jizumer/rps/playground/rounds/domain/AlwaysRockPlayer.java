package com.github.jizumer.rps.playground.rounds.domain;

import java.util.Objects;

public class AlwaysRockPlayer implements Player {

    private final String id;

    public AlwaysRockPlayer(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return null;
    }

    @Override
    public Move play() {
        return Move.ROCK;
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
