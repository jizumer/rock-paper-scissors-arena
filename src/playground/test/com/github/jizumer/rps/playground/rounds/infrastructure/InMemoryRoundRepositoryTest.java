package com.github.jizumer.rps.playground.rounds.infrastructure;

import com.github.jizumer.rps.core.infrastructure.InfrastructureTestCase;
import com.github.jizumer.rps.playground.rounds.domain.Round;
import com.github.jizumer.rps.playground.rounds.domain.RoundGenerator;
import com.github.jizumer.rps.playground.rounds.domain.RoundIdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class InMemoryRoundRepositoryTest extends InfrastructureTestCase {

    @Autowired
    InMemoryRoundRepository repository;

    @Test
    void shouldSaveRoundsInMemoryHashMap() {
        //There is a rule that states that player 1 will play randomly, and player 2 will always play rock
        Round roundToBeSaved = RoundGenerator.random();
        repository.save(roundToBeSaved);

        assertEquals(Optional.of(roundToBeSaved), repository.search(roundToBeSaved.getId()));
    }

    @Test
    void shouldReturnAPreviouslySavedRound() {
        Round randomRound = RoundGenerator.random();
        repository.save(randomRound);
        Optional<Round> returnedOptional = repository.search(randomRound.getId());
        assertTrue(returnedOptional.isPresent());
        assertEquals(randomRound, returnedOptional.get());
    }

    @Test
    void shouldNotReturnARoundNotPreviouslySaved() {
        assertFalse(repository.search(RoundIdGenerator.random()).isPresent());
    }
}