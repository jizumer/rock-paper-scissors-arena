package com.github.jizumer.rps.playground.rounds.application;

import java.util.Objects;

public class RoundSearcherRequest {
    private final String idPlayer;

    public RoundSearcherRequest(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundSearcherRequest that = (RoundSearcherRequest) o;
        return Objects.equals(idPlayer, that.idPlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer);
    }
}
