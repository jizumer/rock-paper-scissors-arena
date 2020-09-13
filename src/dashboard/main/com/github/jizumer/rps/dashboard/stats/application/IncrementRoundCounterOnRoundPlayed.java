package com.github.jizumer.rps.dashboard.stats.application;

import com.github.jizumer.rps.core.domain.rounds.RoundPlayed;
import com.github.jizumer.rps.dashboard.stats.domain.StatsRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class IncrementRoundCounterOnRoundPlayed {

    StatsRepository statsRepository;

    public IncrementRoundCounterOnRoundPlayed(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    //Process incoming events from playground bounded context
    @EventListener
    public void onEvent(RoundPlayed roundPlayed) {
        System.out.println(String.format("Event received in dashboard context: %s", roundPlayed));
        //It is important not to return an error here if we don't want to receive the event again
        statsRepository.includeRoundInStats(roundPlayed);
    }

}
