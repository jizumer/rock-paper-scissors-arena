package com.github.jizumer.rps.dashboard.stats.infrastructure;

import com.github.jizumer.rps.core.domain.rounds.RoundPlayed;
import com.github.jizumer.rps.core.domain.rounds.RoundResult;
import com.github.jizumer.rps.dashboard.stats.domain.StatsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public final class InMemoryStatsRepository implements StatsRepository {

    private final List<String> roundsConsideredInStats;
    //Atomic long is not strictly necessary, but we are using convenient incrementAndGet method.
    private final AtomicLong player1Wins;
    private final AtomicLong player2Wins;
    private final AtomicLong draws;

    public InMemoryStatsRepository() {
        this.roundsConsideredInStats = new ArrayList<>();

        this.player1Wins = new AtomicLong();
        this.player2Wins = new AtomicLong();
        this.draws = new AtomicLong();
    }

    @Override
    public long countRoundsByResult(RoundResult result) {
        return findResultCounterByResult(result).get();
    }

    @Override
    public synchronized void includeRoundInStats(RoundPlayed roundPlayed) {
        //Attention to concurrency here. In a real transactional implementation, it will not be necessary.
        if (!roundsConsideredInStats.contains(roundPlayed.getRoundId())) {
            roundsConsideredInStats.add(roundPlayed.getRoundId());
            findResultCounterByResult(RoundResult.valueOf(roundPlayed.getResult())).incrementAndGet();
        }
    }

    private AtomicLong findResultCounterByResult(RoundResult resultCounter) {
        switch (resultCounter) {
            case P1_WINS:
                return this.player1Wins;
            case P2_WINS:
                return this.player2Wins;
            case DRAW:
                return this.draws;
            default:
                throw new IllegalArgumentException(String.format(
                        "Impossible to proccess the result %s", resultCounter));
        }
    }
}