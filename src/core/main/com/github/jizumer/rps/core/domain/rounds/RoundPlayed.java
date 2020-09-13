package com.github.jizumer.rps.core.domain.rounds;

import com.github.jizumer.rps.core.domain.DomainEvent;

public class RoundPlayed extends DomainEvent {
    private final static String AGGREGATE_NAME = "Round";

    private final String id;
    private final String player1Id;
    private final String player2Id;
    private final String player1Move;
    private final String player2Move;
    private final String result;

    public RoundPlayed(String id, String player1Id, String player2Id, String player1Move, String player2Move, String result) {
        super(AGGREGATE_NAME);
        this.id = id;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.player1Move = player1Move;
        this.player2Move = player2Move;
        this.result = result;
    }

    @Override
    public String toString() {
        return "RoundPlayed{" +
                "id='" + id + '\'' +
                ", player1Id='" + player1Id + '\'' +
                ", player2Id='" + player2Id + '\'' +
                ", player1Move='" + player1Move + '\'' +
                ", player2Move='" + player2Move + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
