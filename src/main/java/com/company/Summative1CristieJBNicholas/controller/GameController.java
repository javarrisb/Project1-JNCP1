package com.company.Summative1CristieJBNicholas.controller;


import com.company.Summative1CristieJBNicholas.exception.ProductNotFoundException;
import com.company.Summative1CristieJBNicholas.models.Games;

import com.company.Summative1CristieJBNicholas.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository repo;

    @GetMapping(value="/games/game")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {
        return repo.findAll();
    }

    // get games by ID
    @GetMapping("/games/{id}")
    public Games getGameById(@PathVariable Integer id) {
        // from echo-range-service class work
        if (id < 1) {
            throw new IllegalArgumentException("Game ID must be at least 1");
        }
        Optional<Games> returnVal = repo.findById(id);
        if (returnVal.isPresent()){
            return returnVal.get();
        } else {
            throw new ProductNotFoundException("No such console. id:  " + id);
        }
    }
    @GetMapping(value="/games/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesbyTitle(@PathVariable String title)
    {return repo.findByTitle(title);}

    @GetMapping(value="/games/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByStudio(@PathVariable String studio){
        return repo.findByStudio(studio);}

    @GetMapping(value="/games/esrbRating/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByEsrbRating(@PathVariable String esrbRating){
        return repo.findByEsrbRating(esrbRating);
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
        if (id < 1) {
            throw new IllegalArgumentException("Cannot delete a Game unless Game ID is at least 1");
        }
        repo.deleteById(id);
    }
}
