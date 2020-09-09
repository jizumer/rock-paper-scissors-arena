package com.github.jizumer.rps.playground.rounds.infrastructure;

import com.github.jizumer.rps.core.infrastructure.InfrastructureTestCase;
import com.github.jizumer.rps.playground.rounds.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Test
    void shouldFindAllRoundsPlayedByAGivenPlayer() {
        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());
        RoundId round1Id = RoundIdGenerator.random();
        Round firsRound = RoundGenerator.buildFromIds(round1Id.getValue(), playerId.toString());
        repository.save(firsRound);

        RoundCriteria criteria = new RoundCriteria(playerId);
        List<Round> rounds = repository.searchByCriteria(criteria);
        assertEquals(1, rounds.size());
        assertEquals(round1Id.getValue(), rounds.get(0).getId().getValue());
    }

    @Test
    void shouldFindOnlyRoundsPlayedByAGivenPlayerBetweenOthersPreviouslySavedRounds() {
        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());
        RoundId round1Id = RoundIdGenerator.random();
        Round firsRound = RoundGenerator.buildFromIds(round1Id.getValue(), playerId.toString());
        repository.save(firsRound);

        Round secondRound = RoundGenerator.buildFromIds(RoundIdGenerator.random().getValue(), playerId.toString());
        repository.save(secondRound);

        Round thirdRoundPlayedByOtherPlayer = RoundGenerator.buildFromIds(RoundIdGenerator.random().getValue(),
                UUID.randomUUID().toString());
        repository.save(thirdRoundPlayedByOtherPlayer);

        RoundCriteria criteria = new RoundCriteria(playerId);
        List<Round> rounds = repository.searchByCriteria(criteria);
        assertEquals(2, rounds.size());
        assertTrue(rounds.stream().allMatch(round ->
                round
                        .getPlayer1()
                        .getId()
                        .equals(playerId.toString())));
    }
}