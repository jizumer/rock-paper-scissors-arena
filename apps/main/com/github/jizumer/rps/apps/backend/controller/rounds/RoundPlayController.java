package com.github.jizumer.rps.apps.backend.controller.rounds;

import com.github.jizumer.rps.playground.rounds.application.RoundPlayer;
import com.github.jizumer.rps.playground.rounds.application.RoundPlayerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class RoundPlayController {
    private final RoundPlayer roundPlayer;

    public RoundPlayController(RoundPlayer roundPlayer) {
        this.roundPlayer = roundPlayer;
    }

    //It is a PUT method, since Id comes previously generated from caller.
    @SuppressWarnings("rawtypes")
    @PutMapping(value = "/rounds/play/{idRound}")
    public ResponseEntity play(@PathVariable String idRound, @RequestBody RoundPlayControllerRequest roundPlayControllerRequest) {

        //RoundPlayer is the application service. It could be called RoundCreator to differentiate its naming from
        //Player entity.
        this.roundPlayer.playRound(new RoundPlayerRequest(roundPlayControllerRequest.getIdPlayer(), idRound));

        //As id is received, it is considered a PUT, and we will not return any data despite of the HTTP status.
        return new ResponseEntity(HttpStatus.CREATED);
        //Error control is required, returning the right HTTP status codes
    }


}

