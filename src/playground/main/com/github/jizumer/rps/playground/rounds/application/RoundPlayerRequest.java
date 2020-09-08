package com.github.jizumer.rps.playground.rounds.application;

import java.util.Objects;

public class RoundPlayerRequest {
    private final String idUser;
    private final String idRound;

    public RoundPlayerRequest(String idUser, String idRound) {
        this.idUser = idUser;
        this.idRound = idRound;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdRound() {
        return idRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundPlayerRequest that = (RoundPlayerRequest) o;
        return Objects.equals(idUser, that.idUser) &&
                Objects.equals(idRound, that.idRound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idRound);
    }
}
