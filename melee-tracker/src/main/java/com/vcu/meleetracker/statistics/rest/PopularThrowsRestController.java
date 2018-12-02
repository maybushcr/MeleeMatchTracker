package com.vcu.meleetracker.statistics.rest;

import com.vcu.meleetracker.statistics.dao.PopularThrowsDao;
import com.vcu.meleetracker.statistics.dto.PopularThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PopularThrowsRestController {

    @Autowired
    PopularThrowsDao popularThrowsDao;

    @GetMapping("/api/statistics/popularthrows")
    public List<PopularThrows> getPopularThrows(){
        return popularThrowsDao.findAll();
    }
}
