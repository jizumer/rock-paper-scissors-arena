package com.github.jizumer.rps.dashboard.stats.application;

import com.github.jizumer.rps.core.domain.rounds.RoundPlayed;
import com.github.jizumer.rps.dashboard.stats.domain.StatsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class IncrementRoundCounterOnRoundPlayedTest {
    @Mock
    StatsRepository statsRepository;

    @InjectMocks
    IncrementRoundCounterOnRoundPlayed incrementRoundCounterOnRoundPlayed;

    @Test
    public void shouldCallIncrementMethodInRepository() {
        RoundPlayed eventMock = mock(RoundPlayed.class);
        incrementRoundCounterOnRoundPlayed.onEvent(eventMock);
    }
}