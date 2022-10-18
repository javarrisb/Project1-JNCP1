package com.company.Summative1CristieJBNicholas.controller;


import com.company.Summative1CristieJBNicholas.models.Games;
import com.company.Summative1CristieJBNicholas.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameRepository repo;

    @GetMapping(value="/games/title")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesbyTitle(@PathVariable String title)
    {return repo.findAllGamesByTitle(title);}


}
