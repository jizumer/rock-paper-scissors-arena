package com.github.jizumer.rps.dashboard.stats.domain;

import com.github.jizumer.rps.core.domain.rounds.RoundPlayed;
import com.github.jizumer.rps.core.domain.rounds.RoundResult;

public interface StatsRepository {
    long countRoundsByResult(RoundResult result);

    //An event should not be directly processed in domain, but an specific request
    void includeRoundInStats(RoundPlayed roundPlayed);
}
