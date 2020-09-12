package com.github.jizumer.rps.apps.frontend.controller.playground;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaygroundsGetController {

    @GetMapping(value = "/playground")
    public String stats(Model model) {

        return "playground";
    }
}
