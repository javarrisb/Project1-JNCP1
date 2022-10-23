package com.company.Summative1CristieJBNicholas.controller;


import com.company.Summative1CristieJBNicholas.exception.QueryNotFoundException;
import com.company.Summative1CristieJBNicholas.models.Games;

import com.company.Summative1CristieJBNicholas.repository.GameRepository;
import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.support.QueryMethodParameterConversionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

//    @Autowired
//    GameRepository repo;

    @Autowired
    ServiceLayer serviceLayer;


//    @GetMapping(value="/games/game")
    @GetMapping(value="/games/allgames")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames(@RequestParam(required = false) String studio, @RequestParam(required = false) String esrbRating) {
        if(studio != null && esrbRating != null){
            return serviceLayer.getGamesByStudioAndEsrbRating(studio, esrbRating);
        }else if(studio != null){
            return serviceLayer.getGamesByStudio(studio);
        }else if (esrbRating != null){
            return serviceLayer.getGamesByStudio(esrbRating);
        }
        return serviceLayer.getAllGames();
    }

    // get games by ID
    @GetMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Games> getSingleGameById(@PathVariable Integer id, @RequestParam(required = false)String title) throws QueryNotFoundException {
        if (title != null) {
            return serviceLayer.findByTitle(title);
        }
        if (serviceLayer.getSingleGameById(id).orElse(null) == null) {
            throw new QueryNotFoundException("The game with that title does not exist in our inventory.");
        }
        return serviceLayer.getSingleGameById(id);
    }

        // from echo-range-service class work
// old:       if (id < 1) {
//            throw new IllegalArgumentException("Game ID must be at least 1");
//        }
//        Optional<Invoice> returnVal = serviceLayer.findById(id);
//        if (returnVal.isPresent()){
//            return returnVal.get();
//        } else {
//            throw new ProductNotFoundException("No such console. id:  " + id);
//        }
//

    @GetMapping(value="/games/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Games> getGamesbyTitle(@PathVariable String title)
    {
        return serviceLayer.findByTitle(title);
    }

    @GetMapping(value="/games/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesByStudio(@PathVariable String studio){
        return serviceLayer.getGamesByStudio(studio);
    }

//    @GetMapping(value="/games/esrbRating/{esrbRating}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Games> getGamesByEsrbRating(@PathVariable String esrbRating){
//        return serviceLayer.getGamesByEsrbRating(String, esrbRating);
//    }

    @PostMapping(value="/games/add")
    @ResponseStatus(HttpStatus.CREATED)
//    "create game"
    public Games addGame(@RequestBody Games game) {
//        return repo.save(game);
    return serviceLayer.addGame(game);
    }


    @PutMapping(value="/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Games game, @PathVariable Integer id) throws QueryNotFoundException {
        if(game.getGame_Id() == null){
            game.setGame_Id(id);
    }
        if(id != game.getGame_Id()){
            throw new DataIntegrityViolationException("Request body ID does not match Path Variable Id.");
        }
        if(serviceLayer.getSingleGameById(id).orElse(null) == null){
            throw new QueryNotFoundException("That game title does not exist in our inventory.");
        }
        serviceLayer.updateGame(game);

//  old:  public void updateGames(@RequestBody Games game) {
//        repo.save(game);
    }

    @DeleteMapping(value="/games/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer id) throws QueryNotFoundException {
        if(serviceLayer.getSingleGameById(id).orElse(null) == null){
            throw new QueryNotFoundException("That game title does not exist in our inventory.");
        }
// old:       if (id < 1) {
//            throw new IllegalArgumentException("Cannot delete a Game unless Game ID is at least 1");
//        }
//        repo.deleteById(id);
    }
}
