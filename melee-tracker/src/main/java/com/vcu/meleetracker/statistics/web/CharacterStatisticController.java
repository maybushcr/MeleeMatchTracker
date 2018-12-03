package com.vcu.meleetracker.statistics.web;

import com.vcu.meleetracker.statistics.dao.CharacterPickRateDao;
import com.vcu.meleetracker.statistics.dao.CharacterWinRateByCharacterDao;
import com.vcu.meleetracker.statistics.dao.CharacterWinRateDao;
import com.vcu.meleetracker.statistics.dao.WeightWinRateDao;
import com.vcu.meleetracker.statistics.dto.CharacterPickRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistics/character")
public class CharacterStatisticController {

    @Autowired
    CharacterWinRateByCharacterDao characterWinRateByCharacterDao;

    @Autowired
    WeightWinRateDao weightWinRateDao;

    @Autowired
    CharacterPickRateDao characterPickRateDao;

    @Autowired
    CharacterWinRateDao characterWinRateDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getStageStatistics(Model model){
        model.addAttribute("character_win_rate_by_character",characterWinRateByCharacterDao.findAll());
        model.addAttribute("weight_win_rate",weightWinRateDao.findAll());
        model.addAttribute("character_pick_rate",characterPickRateDao.findAll());
        model.addAttribute("character_win_rate",characterWinRateDao.findAll());
        return "statistics/character";
    }

}
