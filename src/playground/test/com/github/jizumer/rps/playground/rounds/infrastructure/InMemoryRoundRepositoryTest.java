package com.github.jizumer.rps.playground.rounds.infrastructure;

import com.github.jizumer.rps.core.infrastructure.InfrastructureTestCase;
import com.github.jizumer.rps.playground.rounds.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class InMemoryRoundRepositoryTest extends InfrastructureTestCase {

    @Autowired
    InMemoryRoundRepository repository;

    @Test
    void shouldSaveRoundsInMemoryHashMap() {
        //There is a rule that states that player 1 will play randomly, and player 2 will always play rock
        Round roundToBeSaved = new Round(new RoundId(UUID.randomUUID().toString()),
                new RandomPlayer(new PlayerId(UUID.randomUUID().toString())),
                new AlwaysRockPlayer(UUID.randomUUID().toString()));
        repository.save(roundToBeSaved);

        assertEquals(Optional.of(roundToBeSaved), repository.search(roundToBeSaved.getId()));
    }
}