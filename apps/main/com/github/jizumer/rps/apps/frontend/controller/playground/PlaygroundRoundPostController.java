package com.github.jizumer.rps.apps.frontend.controller.playground;

import com.github.jizumer.rps.playground.rounds.application.RoundPlayer;
import com.github.jizumer.rps.playground.rounds.application.RoundPlayerRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.Serializable;
import java.util.HashMap;

@Controller
public class PlaygroundRoundPostController {
    private final RoundPlayer roundPlayer;

    public PlaygroundRoundPostController(RoundPlayer roundPlayer) {
        this.roundPlayer = roundPlayer;
    }

    @PostMapping(value = "/playground", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RedirectView playNewRound(@RequestParam HashMap<String, Serializable> request) {

        String idPlayer = request.get("idPlayer").toString();
        String idRound = request.get("idRound").toString();

        roundPlayer.playRound(new RoundPlayerRequest(idPlayer,
                idRound));

        return new RedirectView("/playground/" + idPlayer);
    }
}
