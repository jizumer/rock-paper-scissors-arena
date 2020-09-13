package com.github.jizumer.rps.dashboard.stats.application;


import com.github.jizumer.rps.core.domain.rounds.RoundResult;
import com.github.jizumer.rps.dashboard.stats.domain.Stats;
import com.github.jizumer.rps.dashboard.stats.domain.StatsGenerator;
import com.github.jizumer.rps.dashboard.stats.domain.StatsRepository;
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
    StatsRepository statsRepository;

    @InjectMocks
    StatsCollector statsCollector;

    @BeforeEach
    void setUp() {
        statsCollector = new StatsCollector(statsRepository);
    }

    @Test
    void shouldCollectStats() {
        Stats statsMock = mock(Stats.class);
        when(statsRepository.countRoundsByResult(RoundResult.P1_WINS)).thenReturn(3565L);
        when(statsRepository.countRoundsByResult(RoundResult.P2_WINS)).thenReturn(1644L);
        when(statsRepository.countRoundsByResult(RoundResult.DRAW)).thenReturn(25L);

        Stats expectedStats = StatsGenerator.buildFromValues(3565L,
                1644L,
                25L);

        Stats calculatedStats = statsCollector.collectStats();
        Assert.assertEquals(expectedStats, calculatedStats);
        verify(statsRepository, Mockito.times(3)).countRoundsByResult(any(RoundResult.class));
    }
}