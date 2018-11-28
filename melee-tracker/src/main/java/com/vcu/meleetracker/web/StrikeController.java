package com.vcu.meleetracker.web;

import com.vcu.meleetracker.repo.StrikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/strikes")
public class StrikeController {

    @Autowired
    StrikeRepository StrikeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getStrikes(Model model){
        model.addAttribute("strikes",StrikeRepository.findAll());
        return "strikes";
    }
}
