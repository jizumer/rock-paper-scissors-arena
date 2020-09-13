package com.github.jizumer.rps.dashboard.stats.application;

import com.github.jizumer.rps.core.domain.rounds.RoundPlayed;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class IncrementRoundCounterOnRoundPlayed {

    //Process incoming events from playground bounded context
    @EventListener
    public void onEvent(RoundPlayed roundPlayed) {
        System.out.println(String.format("Event received in dashboard context: %s", roundPlayed));
    }

}
