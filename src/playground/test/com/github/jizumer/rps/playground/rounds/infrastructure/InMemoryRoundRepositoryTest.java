package com.github.jizumer.rps.playground.rounds.infrastructure;

import com.github.jizumer.rps.core.infrastructure.InfrastructureTestCase;
import com.github.jizumer.rps.playground.rounds.domain.AlwaysRockPlayer;
import com.github.jizumer.rps.playground.rounds.domain.RandomPlayer;
import com.github.jizumer.rps.playground.rounds.domain.Round;
import com.github.jizumer.rps.playground.rounds.domain.RoundId;
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
        Round roundToBeSaved = new Round(new RoundId("id1"),
                new RandomPlayer(UUID.randomUUID().toString()),
                new AlwaysRockPlayer(UUID.randomUUID().toString()));
        repository.save(roundToBeSaved);

        assertEquals(Optional.of(roundToBeSaved), repository.search(roundToBeSaved.getId()));
    }
}