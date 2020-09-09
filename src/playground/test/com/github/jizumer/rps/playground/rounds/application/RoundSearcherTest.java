package com.github.jizumer.rps.playground.rounds.application;

import com.github.jizumer.rps.core.domain.UuidGenerator;
import com.github.jizumer.rps.playground.rounds.domain.RoundCriteria;
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
public class RoundSearcherTest {

    @Mock
    RoundRepository repo;

    @InjectMocks
    RoundSearcher roundSearcher;

    @BeforeEach
    protected void setUp() {
        roundSearcher = new RoundSearcher(repo);
    }

    @Test
    void shouldFindRoundsByCriteria() {
        roundSearcher.searchByCriteria(new RoundSearcherRequest(UuidGenerator.random()));
        verify(repo, Mockito.atLeastOnce()).searchByCriteria(any(RoundCriteria.class));
    }
}
