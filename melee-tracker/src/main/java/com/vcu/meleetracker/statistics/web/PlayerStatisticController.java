package com.vcu.meleetracker.statistics.web;

import com.vcu.meleetracker.database.repo.PlayerRepository;
import com.vcu.meleetracker.statistics.dao.*;
import com.vcu.meleetracker.statistics.dto.AverageStockDifference;
import com.vcu.meleetracker.statistics.dto.PlayerWinRateByPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistics/player")
public class PlayerStatisticController {

    @Autowired
    PlayerWinRateDao playerWinRateDao;

    @Autowired
    PlayerWinRateByPlayerDao playerWinRateByPlayerDao;

    @Autowired
    CharacterPickRateByPlayerDao characterPickRateByPlayerDao;

    @Autowired
    PlayerWinRateByCharacterDao playerWinRateByCharacterDao;

    @Autowired
    PlayerMatchesPlayedDao playerMatchesPlayedDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getPlayerStatistics(Model model){
        model.addAttribute("player_win_rate",playerWinRateDao.findAll());
        model.addAttribute("player_win_rate_by_player",playerWinRateByPlayerDao.findAll());
        model.addAttribute("character_pick_rate_by_player",characterPickRateByPlayerDao.findAll());
        model.addAttribute("player_win_rate_by_character",playerWinRateByCharacterDao.findAll());
        model.addAttribute("player_matches_played",playerMatchesPlayedDao.findAll());
        return "statistics/player";
    }


}
