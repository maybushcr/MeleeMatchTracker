package com.vcu.meleetracker.statistics.web;


import com.vcu.meleetracker.database.repo.PlayerRepository;
import com.vcu.meleetracker.statistics.dao.PVPWinRatesDao;
import com.vcu.meleetracker.statistics.dao.PopularThrowsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    PopularThrowsDao popularThrowsDao;
    @Autowired
    PVPWinRatesDao pvpWinRatesDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getPlayers(Model model){
        model.addAttribute("popular_throws",popularThrowsDao.findAll());
        model.addAttribute("pvp_win_rates",pvpWinRatesDao.findAll());
        return "index";
    }
}
