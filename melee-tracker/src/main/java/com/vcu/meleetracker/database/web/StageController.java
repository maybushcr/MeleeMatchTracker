package com.vcu.meleetracker.database.web;

import com.vcu.meleetracker.database.repo.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/stages")
public class StageController {

    @Autowired
    StageRepository StageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getStages(Model model){
        model.addAttribute("stages",StageRepository.findAll());
        return "stages";
    }
}
