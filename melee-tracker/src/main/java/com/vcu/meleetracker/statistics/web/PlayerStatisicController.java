package com.vcu.meleetracker.statistics.web;

import com.vcu.meleetracker.statistics.dao.AverageStockDifferenceDao;
import com.vcu.meleetracker.statistics.dto.AverageStockDifference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistics/players")
public class PlayerStatisicController {

    @Autowired
    AverageStockDifferenceDao averageStockDifferenceDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getPlayerStatistics(Model model){
        model.addAttribute("average_stock_difference",averageStockDifferenceDao.findAll());
        return "statistics/players";
    }


}
