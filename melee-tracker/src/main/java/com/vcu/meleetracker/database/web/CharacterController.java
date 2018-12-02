package com.vcu.meleetracker.database.web;

import com.vcu.meleetracker.database.repo.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/characters")
public class CharacterController {

    @Autowired
    CharacterRepository CharacterRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getCharacters(Model model){
        model.addAttribute("characters",CharacterRepository.findAll());
        return "characters";
    }
}
