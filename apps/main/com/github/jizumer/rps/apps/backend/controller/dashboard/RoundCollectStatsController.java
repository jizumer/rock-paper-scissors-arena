package com.github.jizumer.rps.apps.backend.controller.dashboard;

import com.github.jizumer.rps.dashboard.stats.application.StatsCollector;
import com.github.jizumer.rps.dashboard.stats.domain.Stats;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class RoundCollectStatsController {
    private final StatsCollector statsCollector;

    public RoundCollectStatsController(StatsCollector statsCollector) {
        this.statsCollector = statsCollector;
    }

    //Only for test purposes
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/stats")
    public ResponseEntity<Stats> collectStats() {

        //Mapping to DTOs is required here, to decouple from communication layer

        return new ResponseEntity<>(statsCollector.collectStats(), HttpStatus.OK);
        //Error control is required, returning the right HTTP status codes
    }

}

