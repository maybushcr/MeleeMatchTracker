package com.vcu.meleetracker.database.web;

import com.vcu.meleetracker.database.repo.RockPaperScissorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/rock_paper_scissors")
public class RockPaperScissorsController {

    @Autowired
    RockPaperScissorsRepository RockPaperScissorsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getrock_raper_scissors(Model model){
        model.addAttribute("rock_paper_scissors",RockPaperScissorsRepository.findAll());
        return "rock_paper_scissors";
    }
}
