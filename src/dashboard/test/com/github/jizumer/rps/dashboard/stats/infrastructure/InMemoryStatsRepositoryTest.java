package com.github.jizumer.rps.dashboard.stats.infrastructure;

import com.github.jizumer.rps.core.domain.rounds.RoundPlayed;
import com.github.jizumer.rps.core.domain.rounds.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InMemoryStatsRepositoryTest {

    InMemoryStatsRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new InMemoryStatsRepository();
    }


    @Test
    void shouldCountZeroRoundsAtTheBeginning() {
        assertEquals(0L, repository.countRoundsByResult(RoundResult.P1_WINS));
        assertEquals(0L, repository.countRoundsByResult(RoundResult.P2_WINS));
        assertEquals(0L, repository.countRoundsByResult(RoundResult.DRAW));

    }


    @Test
    void shouldCountRightNumberOfRounds() {
        RoundPlayed p1WinMock = generateRoundPlayedMock(RoundResult.P1_WINS);
        RoundPlayed p2WinMock = generateRoundPlayedMock(RoundResult.P2_WINS);
        RoundPlayed drawMock = generateRoundPlayedMock(RoundResult.DRAW);

        for (int i = 0; i < 5; i++) {
            repository.includeRoundInStats(p1WinMock);
        }
        for (int i = 0; i < 10; i++) {
            repository.includeRoundInStats(p2WinMock);
        }
        for (int i = 0; i < 15; i++) {
            repository.includeRoundInStats(drawMock);
        }

        assertEquals(5L, repository.countRoundsByResult(RoundResult.P1_WINS));
        assertEquals(10L, repository.countRoundsByResult(RoundResult.P2_WINS));
        assertEquals(15L, repository.countRoundsByResult(RoundResult.DRAW));

    }

    @Test
    void shouldNotIncludeTwiceTheSameRoundInStats() {
        String fakeIdRound = UUID.randomUUID().toString();
        repository.includeRoundInStats(generateRoundPlayedMock(fakeIdRound, RoundResult.P1_WINS));
        assertEquals(1L, repository.countRoundsByResult(RoundResult.P1_WINS));
        repository.includeRoundInStats(generateRoundPlayedMock(fakeIdRound, RoundResult.P1_WINS));
        assertEquals(1L, repository.countRoundsByResult(RoundResult.P1_WINS));
    }

    private RoundPlayed generateRoundPlayedMock(RoundResult result) {
        return generateRoundPlayedMock(UUID.randomUUID().toString(), result);
    }

    private RoundPlayed generateRoundPlayedMock(String idRound, RoundResult result) {
        RoundPlayed mock = Mockito.mock(RoundPlayed.class);
        when(mock.getRoundId()).thenReturn(idRound);
        when(mock.getResult()).thenReturn(result.toString());
        return mock;
    }
}