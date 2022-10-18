package com.company.Summative1CristieJBNicholas.controller;


import com.company.Summative1CristieJBNicholas.models.Games;
import com.company.Summative1CristieJBNicholas.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameRepository repo;

    @GetMapping(value="/games/game")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {
        return repo.findAll();
    }

    @GetMapping(value="/games/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesbyTitle(@PathVariable String title)
    {return repo.findAllGamesByTitle(title);}

    @GetMapping(value="/games/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByStudio(@PathVariable String studio){
        return repo.findAllGamesByStudio(studio);}

    @GetMapping(value="/games/esrbRating/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByEsrbRating(@PathVariable String esrbRating){
        return repo.findAllGamesByEsrbRating(esrbRating);
    }

    @PostMapping(value="/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Games addGame(@RequestBody Games game) {
        return repo.save(game);
    }

    @PutMapping(value="/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGames(@RequestBody Games game) {
        repo.save(game);
    }

    @DeleteMapping(value="/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer id){
        repo.deleteById(id);
    }

}
