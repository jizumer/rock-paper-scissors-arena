package com.github.jizumer.rps.dashboard.stats.application;

import com.github.jizumer.rps.core.domain.rounds.RoundResult;
import com.github.jizumer.rps.dashboard.stats.domain.ResultCounter;
import com.github.jizumer.rps.dashboard.stats.domain.Stats;
import com.github.jizumer.rps.dashboard.stats.domain.StatsRepository;
import org.springframework.stereotype.Service;


@Service
public class StatsCollector {

    private StatsRepository statsRepository;

    public StatsCollector(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }


    public Stats collectStats() {
        long player1Wins = statsRepository.countRoundsByResult(RoundResult.P1_WINS);
        long player2Wins = statsRepository.countRoundsByResult(RoundResult.P2_WINS);
        long draws = statsRepository.countRoundsByResult(RoundResult.DRAW);
        return new Stats(new ResultCounter(player1Wins),
                new ResultCounter(player2Wins),
                new ResultCounter(draws));
    }
}
