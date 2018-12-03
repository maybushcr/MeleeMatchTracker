package com.vcu.meleetracker.statistics.web;

import com.vcu.meleetracker.statistics.dao.CharacterPickRateDao;
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
    CharacterPickRateDao characterPickRateDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getStageStatistics(Model model){
        model.addAttribute("character_pick_rate",characterPickRateDao.findAll());
        return "statistics/character";
    }

}
