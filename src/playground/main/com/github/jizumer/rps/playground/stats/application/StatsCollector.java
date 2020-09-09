package com.github.jizumer.rps.playground.stats.application;

import com.github.jizumer.rps.playground.rounds.domain.RoundRepository;
import com.github.jizumer.rps.playground.rounds.domain.RoundResult;
import com.github.jizumer.rps.playground.stats.domain.ResultCounter;
import com.github.jizumer.rps.playground.stats.domain.Stats;
import org.springframework.stereotype.Service;


@Service
public class StatsCollector {

    //It would be better to use a EventBus approach, synchronous or asynchronous, rather than directly calling
    //other module's repository. Nice feature for the future: create an event bus and populate an event every time
    // a Round is played. This event will be consumed by Stats Collector in dashboard bounded context.
    private RoundRepository roundRepository;

    public StatsCollector(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }


    public Stats collectStats() {
        long player1Wins = roundRepository.countByResult(RoundResult.P1_WINS);
        long player2Wins = roundRepository.countByResult(RoundResult.P2_WINS);
        long draws = roundRepository.countByResult(RoundResult.DRAW);
        return new Stats(new ResultCounter(player1Wins),
                new ResultCounter(player2Wins),
                new ResultCounter(draws));
    }
}
