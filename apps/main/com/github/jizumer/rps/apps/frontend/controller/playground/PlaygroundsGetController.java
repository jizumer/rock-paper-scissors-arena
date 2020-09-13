package com.github.jizumer.rps.apps.frontend.controller.playground;

import com.github.jizumer.rps.playground.rounds.application.RoundSearcher;
import com.github.jizumer.rps.playground.rounds.application.RoundSearcherRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class PlaygroundsGetController {
    private final RoundSearcher roundSearcher;

    public PlaygroundsGetController(RoundSearcher roundSearcher) {
        this.roundSearcher = roundSearcher;
    }

    @GetMapping(value = "/playground/{idPlayer}")
    public String searchByFirstPlayerId(@PathVariable String idPlayer, Model model) {

        //Mapping to DTOs is required here, to decouple from communication layer

        model.addAttribute("rounds",
                roundSearcher.searchByCriteria(new RoundSearcherRequest(idPlayer)));
        model.addAttribute("idPlayer", idPlayer);

        //Error control is required, returning the right HTTP status codes
        return "playground";
    }

    @GetMapping(value = "/playground")
    public RedirectView firstAccessWithoutIdPlayer() {
        return new RedirectView("/playground/" + UUID.randomUUID().toString());
    }


}
