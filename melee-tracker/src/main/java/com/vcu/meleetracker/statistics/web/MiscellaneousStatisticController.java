package com.vcu.meleetracker.statistics.web;

import com.vcu.meleetracker.statistics.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistics/miscellaneous")
public class MiscellaneousStatisticController {

    @Autowired
    AverageStockDifferenceDao averageStockDifferenceDao;

    @Autowired
    PlayerRockPaperScissorsWinRateDao playerRockPaperScissorsWinRateDao;

    @Autowired
    PopularThrowsDao popularThrowsDao;

    @Autowired
    TournamentTypeFrequencyDao tournamentTypeFrequencyDao;

    @Autowired
    MatchesPlayedOverTimeDao matchesPlayedOverTimeDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getStageStatistics(Model model){
        model.addAttribute("average_stock_difference",averageStockDifferenceDao.findAll());
        model.addAttribute("player_rock_paper_scissors_win_rate",playerRockPaperScissorsWinRateDao.findAll());
        model.addAttribute("popular_throws",popularThrowsDao.findAll());
        model.addAttribute("tournament_type_frequency",tournamentTypeFrequencyDao.findAll());
        model.addAttribute("matches_played_over_time",matchesPlayedOverTimeDao.findAll());
        return "statistics/miscellaneous";
    }
}
