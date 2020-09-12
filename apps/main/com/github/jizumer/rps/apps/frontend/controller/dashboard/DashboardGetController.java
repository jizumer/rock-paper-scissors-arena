package com.github.jizumer.rps.apps.frontend.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardGetController {

    @GetMapping(value = "/dashboard")
    public String stats(Model model) {

        return "dashboard";
    }
}
