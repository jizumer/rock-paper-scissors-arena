package com.github.jizumer.rps.apps.frontend.controller.dashboard;

import com.github.jizumer.rps.playground.stats.application.StatsCollector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardGetController {
    //We are taking advantage of the mono-repo approach so we can inject here evert application service from different
    //bounded contexts (dashboard or playground).
    private final StatsCollector statsCollector;

    public DashboardGetController(StatsCollector statsCollector) {
        this.statsCollector = statsCollector;
    }

    @GetMapping(value = "/dashboard")
    public String stats(Model model) {

        model.addAttribute("stats", statsCollector.collectStats());
        return "dashboard";
    }
}
