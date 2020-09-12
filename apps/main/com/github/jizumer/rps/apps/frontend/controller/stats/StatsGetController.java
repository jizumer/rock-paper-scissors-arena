package com.github.jizumer.rps.apps.frontend.controller.stats;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatsGetController {

    @GetMapping(value = "/stats")
    public String stats(Model model) {

        model.addAttribute("hello_world", "Juan");
        return "stats";
    }
}
