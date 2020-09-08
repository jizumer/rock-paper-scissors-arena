package com.github.jizumer.rps.playground.rounds.application;

import java.util.Objects;

public class RoundPlayerRequest {

    private final String id;
    private final String userId;


    public RoundPlayerRequest(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundPlayerRequest that = (RoundPlayerRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
