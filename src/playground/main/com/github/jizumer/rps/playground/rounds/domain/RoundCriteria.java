package com.github.jizumer.rps.playground.rounds.domain;

public class RoundCriteria {
    private final PlayerId firstPlayerId;

    public RoundCriteria(PlayerId firstPlayerId) {
        validate(firstPlayerId);
        this.firstPlayerId = firstPlayerId;
    }

    //We would validate here that the criteria has the
    // minimum field data to perform a query. In this case, only firstPlayerId
    private void validate(PlayerId firstPlayerId) {
        if (firstPlayerId == null) {
            throw new IllegalArgumentException("At least one criteria field must be not empty.");
        }
    }

    public String getFirstPlayerId() {
        return firstPlayerId.toString();
    }
}
