package com.riot.riot_api.controllers;

import com.riot.riot_api.dto.ChampionRotation;
import com.riot.riot_api.services.ChampionRotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/free-week")
public class ChampionRotationController {

    @Autowired
    private ChampionRotationService service;


    @GetMapping
    public ChampionRotation getFreeWeek() {
        return service.execute();
    }
}
