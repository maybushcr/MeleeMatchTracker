package com.vcu.meleetracker.web;

import com.vcu.meleetracker.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getPlayers(Model model){
        model.addAttribute("players",playerRepository.findAll());
        return "players";
    }
}
