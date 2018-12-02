package com.vcu.meleetracker.statistics.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistics/stage")
public class StageStatisticController {

    @RequestMapping(method = RequestMethod.GET)
    public String getStageStatistics(Model model){
        //model.addAttribute("popular_throws",popularThrowsDao.findAll());
        return "statistics/stage";
    }
}
