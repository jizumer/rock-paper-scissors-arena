package com.github.jizumer.rps.playground.rounds.application;

import java.util.Objects;

public class RoundPlayerRequest {
    private final String idPlayer;
    private final String idRound;

    public RoundPlayerRequest(String idPlayer, String idRound) {
        this.idPlayer = idPlayer;
        this.idRound = idRound;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public String getIdRound() {
        return idRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundPlayerRequest that = (RoundPlayerRequest) o;
        return Objects.equals(idPlayer, that.idPlayer) &&
                Objects.equals(idRound, that.idRound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer, idRound);
    }
}
