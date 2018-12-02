package com.vcu.meleetracker.database.web;

import com.vcu.meleetracker.database.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/matches")
public class MatchController
{
    @Autowired
    MatchRepository MatchRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getMatches(Model model){
        model.addAttribute("matches",MatchRepository.findAll());
        return "matches";
    }
}
