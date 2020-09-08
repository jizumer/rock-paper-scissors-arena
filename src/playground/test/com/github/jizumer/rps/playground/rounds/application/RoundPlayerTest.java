package com.github.jizumer.rps.playground.rounds.application;

import com.github.jizumer.rps.core.domain.UuidGenerator;
import com.github.jizumer.rps.playground.rounds.domain.Round;
import com.github.jizumer.rps.playground.rounds.domain.RoundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RoundPlayerTest {

    @Mock
    RoundRepository repo;

    @InjectMocks
    RoundPlayer roundPlayer;

    @BeforeEach
    protected void setUp() {
        roundPlayer = new RoundPlayer(repo);
    }

    @Test
    void shouldPlayANewRound() {
        RoundPlayerRequest request = new RoundPlayerRequest(UuidGenerator.random(),
                UuidGenerator.random());
        roundPlayer.playRound(request);
        verify(repo, Mockito.atLeastOnce()).save(any(Round.class));
    }
}
