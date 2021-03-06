package com.github.jizumer.rps.playground.rounds.domain;

import com.github.jizumer.rps.core.domain.DomainEventPublisher;
import com.github.jizumer.rps.core.domain.rounds.RoundPlayed;
import com.github.jizumer.rps.core.domain.rounds.RoundResult;

import java.util.Objects;

public class Round extends DomainEventPublisher {
    private final RoundId id;
    private final Player player1;
    private final Player player2;
    private Move player1Move;
    private Move player2Move;
    private final RoundResult result;


    public Round(RoundId id, Player player1, Player player2) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.result = play();
        addEvent(new RoundPlayed(id.getValue(),
                player1.getId(),
                player2.getId(),
                player1Move.name(),
                player2Move.name(),
                result.name()));
    }


    private RoundResult play() {
        player1Move = player1.play();
        player2Move = player2.play();
        RoundResult result = Referee.decide(player1Move, player2Move);
        //Basic logging to standard output
        System.out.printf("%s %s => %s%n",
                player1Move,
                player2Move,
                result);
        return result;
    }

    public RoundId getId() {
        return id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Move getPlayer1Move() {
        return player1Move;
    }

    public Move getPlayer2Move() {
        return player2Move;
    }

    public RoundResult getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return Objects.equals(id, round.id) &&
                Objects.equals(player1, round.player1) &&
                Objects.equals(player2, round.player2) &&
                result == round.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player1, player2, result);
    }
}
