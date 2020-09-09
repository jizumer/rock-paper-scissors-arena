package com.github.jizumer.rps.apps.backend.controller.rounds;

import com.github.jizumer.rps.playground.rounds.application.RoundSearcher;
import com.github.jizumer.rps.playground.rounds.application.RoundSearcherRequest;
import com.github.jizumer.rps.playground.rounds.domain.Round;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class RoundSearchByFirstPlayerIdController {
    private final RoundSearcher roundSearcher;

    public RoundSearchByFirstPlayerIdController(RoundSearcher roundSearcher) {
        this.roundSearcher = roundSearcher;
    }

    //CrossOrigin disabled only for test purposes
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/rounds/player/{idPlayer}")
    public ResponseEntity<List<Round>> searchByFirstPlayerId(@PathVariable String idPlayer) {

        //Mapping to DTOs is required here, to decouple from communication layer
        List<Round> foundRounds = roundSearcher.searchByCriteria(new RoundSearcherRequest(idPlayer));

        return new ResponseEntity<>(foundRounds, HttpStatus.OK);
        //Error control is required, returning the right HTTP status codes
    }


}

