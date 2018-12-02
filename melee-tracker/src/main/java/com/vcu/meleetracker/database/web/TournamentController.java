package com.vcu.meleetracker.database.web;

import com.vcu.meleetracker.database.repo.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/tournaments")
public class TournamentController {

    @Autowired
    TournamentRepository TournamentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getTournaments(Model model){
        model.addAttribute("tournaments",TournamentRepository.findAll());
        return "tournaments";
    }
}
