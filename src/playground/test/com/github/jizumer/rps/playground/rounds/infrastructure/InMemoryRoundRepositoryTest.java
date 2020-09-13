package com.github.jizumer.rps.playground.rounds.infrastructure;

import com.github.jizumer.rps.core.domain.rounds.RoundResult;
import com.github.jizumer.rps.core.infrastructure.InfrastructureTestCase;
import com.github.jizumer.rps.playground.rounds.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

final class InMemoryRoundRepositoryTest extends InfrastructureTestCase {

    InMemoryRoundRepository repository;

    @BeforeEach
    void init() {
        repository = new InMemoryRoundRepository();
    }

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

    @Test
    void shouldCalculateTheRightCounters() {

        Round player1WinRound = mock(Round.class);
        when(player1WinRound.getResult()).thenReturn(RoundResult.P1_WINS);
        when(player1WinRound.getId()).thenReturn(RoundIdGenerator.random());

        Round player2WinRound = mock(Round.class);
        when(player2WinRound.getResult()).thenReturn(RoundResult.P2_WINS);
        when(player2WinRound.getId()).thenReturn(RoundIdGenerator.random());

        Round secondPlayer2WinRound = mock(Round.class);
        when(secondPlayer2WinRound.getResult()).thenReturn(RoundResult.P2_WINS);
        when(secondPlayer2WinRound.getId()).thenReturn(RoundIdGenerator.random());

        Round drawRound = mock(Round.class);
        when(drawRound.getResult()).thenReturn(RoundResult.DRAW);
        when(drawRound.getId()).thenReturn(RoundIdGenerator.random());

        repository.save(drawRound);
        repository.save(player1WinRound);
        repository.save(player2WinRound);
        repository.save(secondPlayer2WinRound);

        assertEquals(1, repository.countByResult(RoundResult.P1_WINS));
        assertEquals(2, repository.countByResult(RoundResult.P2_WINS));
        assertEquals(1, repository.countByResult(RoundResult.DRAW));
    }
}