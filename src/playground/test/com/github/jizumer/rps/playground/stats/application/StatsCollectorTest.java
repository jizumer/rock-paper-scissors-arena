package com.github.jizumer.rps.playground.stats.application;

import com.github.jizumer.rps.playground.rounds.domain.RoundRepository;
import com.github.jizumer.rps.playground.rounds.domain.RoundResult;
import com.github.jizumer.rps.playground.stats.domain.Stats;
import com.github.jizumer.rps.playground.stats.domain.StatsGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatsCollectorTest {

    @Mock
    RoundRepository roundRepository;

    @InjectMocks
    StatsCollector statsCollector;

    @BeforeEach
    void setUp() {
        statsCollector = new StatsCollector(roundRepository);
    }

    @Test
    void shouldCollectStats() {
        Stats statsMock = mock(Stats.class);
        when(roundRepository.countByResult(RoundResult.P1_WINS)).thenReturn(3565L);
        when(roundRepository.countByResult(RoundResult.P2_WINS)).thenReturn(1644L);
        when(roundRepository.countByResult(RoundResult.DRAW)).thenReturn(25L);

        Stats expectedStats = StatsGenerator.buildFromValues(3565L,
                1644L,
                25L);

        Stats calculatedStats = statsCollector.collectStats();
        Assert.assertEquals(expectedStats, calculatedStats);
        verify(roundRepository, Mockito.times(3)).countByResult(any(RoundResult.class));
    }
}