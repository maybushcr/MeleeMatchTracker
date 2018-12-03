package com.vcu.meleetracker.statistics.web;

import com.vcu.meleetracker.database.repo.PlayerRepository;
import com.vcu.meleetracker.statistics.dao.PlayerWinRateByPlayerDao;
import com.vcu.meleetracker.statistics.dao.PopularThrowsDao;
import com.vcu.meleetracker.statistics.dao.AverageStockDifferenceDao;
import com.vcu.meleetracker.statistics.dto.AverageStockDifference;
import com.vcu.meleetracker.statistics.dto.PlayerWinRateByPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistics/players")
public class PlayerStatisticController {

    @Autowired
    AverageStockDifferenceDao averageStockDifferenceDao;
    @Autowired
    PlayerWinRateByPlayerDao playerWinRateByPlayerDao;
    @Autowired
    PopularThrowsDao popularThrowsDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getPlayerStatistics(Model model){
        model.addAttribute("average_stock_difference",averageStockDifferenceDao.findAll());
        model.addAttribute("popular_throws",popularThrowsDao.findAll());
        model.addAttribute("player_win_rate_by_player",playerWinRateByPlayerDao.findAll());
        return "statistics/players";
    }


}
