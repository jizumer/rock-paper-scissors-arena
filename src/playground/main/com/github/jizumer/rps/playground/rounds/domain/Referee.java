package com.github.jizumer.rps.playground.rounds.domain;

import com.github.jizumer.rps.core.domain.rounds.RoundResult;

//Here is where real RPS algorithm takes place. We push the logic towards entities.
//This solution is pretty imperative, but legible and efficient
public class Referee {
    public static RoundResult decide(Move player1Move, Move player2Move) {
        if (player1Move.equals(player2Move)) {
            return RoundResult.DRAW;
        }
        switch (player1Move) {
            case ROCK:
                if (player2Move == Move.SCISSORS) {
                    return RoundResult.P1_WINS;
                }
                break;
            case PAPER:
                if (player2Move == Move.ROCK) {
                    return RoundResult.P1_WINS;
                }
                break;
            case SCISSORS:
                if (player2Move == Move.PAPER) {
                    return RoundResult.P1_WINS;
                }
                break;
        }
        return RoundResult.P2_WINS;
    }
}