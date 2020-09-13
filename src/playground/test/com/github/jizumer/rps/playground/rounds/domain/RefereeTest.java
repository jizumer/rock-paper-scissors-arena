package com.github.jizumer.rps.playground.rounds.domain;

import com.github.jizumer.rps.core.domain.rounds.RoundResult;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RefereeTest {

    @Test
    public void refereeShouldAlwaysRespectRSPRules() {
        //Assert same moves always produce draws
        Assert.assertTrue(Arrays.stream(Move.values())
                .allMatch(move -> Referee.decide(move, move)
                        .equals(RoundResult.DRAW)));

        Assert.assertTrue(List.of(Referee.decide(Move.ROCK, Move.SCISSORS),
                Referee.decide(Move.PAPER, Move.ROCK),
                Referee.decide(Move.SCISSORS, Move.PAPER))
                .stream()
                .allMatch(RoundResult.P1_WINS::equals));

        Assert.assertTrue(List.of(Referee.decide(Move.ROCK, Move.PAPER),
                Referee.decide(Move.PAPER, Move.SCISSORS),
                Referee.decide(Move.SCISSORS, Move.ROCK))
                .stream()
                .allMatch(RoundResult.P2_WINS::equals));
    }


}