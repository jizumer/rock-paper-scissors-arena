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
    @PutMapping(value = "/rounds/play/{idRound}")
    public ResponseEntity<String> play(@PathVariable String idRound, @RequestBody RoundPlayControllerRequest roundPlayControllerRequest) {

        //RoundPlayer is the application service. It could be called RoundCreator to differentiate its naming from
        //Player entity.
        this.roundPlayer.playRound(new RoundPlayerRequest(idRound, roundPlayControllerRequest.getIdUser()));

        //As id is received, it is considered a PUT, and we will not return any data despite of the HTTP status.
        return new ResponseEntity(HttpStatus.CREATED);
    }

    final class RoundPlayControllerRequest {

        private String idUser;

        public String getIdUser() {
            return idUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }
    }


}