package com.company.Summative1CristieJBNicholas.controller;


import com.company.Summative1CristieJBNicholas.exception.ProductNotFoundException;
import com.company.Summative1CristieJBNicholas.exception.QueryNotFoundException;

import com.company.Summative1CristieJBNicholas.models.Games;

import com.company.Summative1CristieJBNicholas.repository.GameRepository;
//import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository repo;

    // create a new Game
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Games addGames(@RequestBody Games games) {
        return repo.save(games);
    }

    // find all Games; from rsvp-service classwork
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {
        return repo.findAll();
    }

    // find Game by iD
    @GetMapping("/games/{gameId}")
    public Games getGameById(@PathVariable Integer gameId) {
        if (gameId < 1) {
            throw new IllegalArgumentException("Game ID must be at least 1");
        }
        Optional<Games> returnVal = repo.findById(gameId);
        if (returnVal.isPresent()){
            return returnVal.get();
        } else {
            throw new ProductNotFoundException("No such game. id:  " + gameId);
        }
    }

    // find by title
    @GetMapping(value="/games/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGameByTitle(@PathVariable String title) {
        return repo.findByTitle(title);
    }

    // find by Esrb Rating
    @GetMapping(value="/games/esrbRating/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGameByEsrbRating(@PathVariable String esrbRating) {
        return repo.findByEsrbRating(esrbRating);
    }
    // find by studio
    @GetMapping(value="/games/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByStudio(@PathVariable String studio){
        return repo.findByStudio(studio);
    }

    // update an existing Game record
    @PutMapping(value = "/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Games games) {
        repo.save(games);
    }

    @DeleteMapping(value="/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer gameId)  {
       repo.deleteById(gameId);
    }
}