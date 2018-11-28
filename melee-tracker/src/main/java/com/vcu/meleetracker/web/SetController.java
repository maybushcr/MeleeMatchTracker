package com.vcu.meleetracker.web;

import com.vcu.meleetracker.repo.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sets")
public class SetController {

    @Autowired
    SetRepository SetRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getSets(Model model) {
        model.addAttribute("sets", SetRepository.findAll());
        return "sets";
    }
}