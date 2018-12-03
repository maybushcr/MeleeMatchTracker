package com.vcu.meleetracker.statistics.web;

import com.vcu.meleetracker.statistics.dao.BannedStageDao;
import com.vcu.meleetracker.statistics.dao.CharacterWinRateByStageDao;
import com.vcu.meleetracker.statistics.dao.PlayerWinRateByStageDao;
import com.vcu.meleetracker.statistics.dao.PopularStageDao;
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

    @Autowired
    PlayerWinRateByStageDao playerWinRateByStageDao;

    @Autowired
    PopularStageDao popularStageDao;

    @Autowired
    BannedStageDao bannedStageDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getStageStatistics(Model model){
        model.addAttribute("character_win_rate_by_stage",characterWinRateByStageDao.findAll());
        model.addAttribute("player_win_rate_by_stage",playerWinRateByStageDao.findAll());
        model.addAttribute("popular_stage",popularStageDao.findAll());
        model.addAttribute("banned_stage",bannedStageDao.findAll());
        return "statistics/stage";
    }
}
