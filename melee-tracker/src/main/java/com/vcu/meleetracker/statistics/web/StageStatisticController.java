package com.vcu.meleetracker.statistics.web;

import com.vcu.meleetracker.statistics.dao.CharacterWinRateByStageDao;
import com.vcu.meleetracker.statistics.dto.CharacterWinRateByStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistics/stage")
public class StageStatisticController {

    @Autowired
    CharacterWinRateByStageDao characterWinRateByStageDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getStageStatistics(Model model){
        model.addAttribute("character_win_rate_by_stage",characterWinRateByStageDao.findAll());
        return "statistics/stage";
    }
}
