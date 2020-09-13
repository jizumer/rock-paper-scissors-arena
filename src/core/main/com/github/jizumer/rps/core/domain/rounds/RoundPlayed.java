package com.github.jizumer.rps.core.domain.rounds;

import com.github.jizumer.rps.core.domain.DomainEvent;

public class RoundPlayed extends DomainEvent {

    private final String roundId;
    private final String player1Id;
    private final String player2Id;
    private final String player1Move;
    private final String player2Move;
    private final String result;

    public RoundPlayed(String roundId, String player1Id, String player2Id, String player1Move,
                       String player2Move, String result) {
        super();
        this.roundId = roundId;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.player1Move = player1Move;
        this.player2Move = player2Move;
        this.result = result;
    }

    public String getRoundId() {
        return roundId;
    }

    public String getPlayer1Id() {
        return player1Id;
    }

    public String getPlayer2Id() {
        return player2Id;
    }

    public String getPlayer1Move() {
        return player1Move;
    }

    public String getPlayer2Move() {
        return player2Move;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "RoundPlayed{" +
                "roundId='" + roundId + '\'' +
                ", player1Id='" + player1Id + '\'' +
                ", player2Id='" + player2Id + '\'' +
                ", player1Move='" + player1Move + '\'' +
                ", player2Move='" + player2Move + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
