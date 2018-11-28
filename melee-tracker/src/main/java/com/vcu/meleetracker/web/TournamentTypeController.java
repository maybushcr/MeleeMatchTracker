package com.vcu.meleetracker.web;

import com.vcu.meleetracker.repo.TournamentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/tournament_types")
public class TournamentTypeController {

    @Autowired
    TournamentTypeRepository TournamentTypeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getTournament_types(Model model){
        model.addAttribute("tournament_types",TournamentTypeRepository.findAll());
        return "tournament_types";
    }
}
