package com.company.Summative1CristieJBNicholas.controller;
import com.company.Summative1CristieJBNicholas.models.Games;
import com.company.Summative1CristieJBNicholas.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository repo;

    // get all games
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {
        return repo.findAll();
    }


     // get games by ID
    @GetMapping("/games/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Games> getSingleGameById(@PathVariable Integer gameId) {
        return repo.findById(gameId);
    }

    // get games by title
    @GetMapping(value="/games/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getByTitle(@PathVariable String title)
    {
        return repo.findByTitle(title);
    }

    // get games by studio
    @GetMapping(value="/games/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getByStudio(@PathVariable String studio){
        return repo.findByStudio(studio);
    }

    // get games by ESRB
    @GetMapping(value="/games/esrbRating/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getByEsrbRating(@PathVariable String esrbRating){return repo.findByEsrbRating(esrbRating);
    }

    // create game
    @PostMapping(value="/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Games addGame(@RequestBody @Valid Games game) {
    return repo.save(game);
    }

    // update game
    @PutMapping(value="/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Games game)  {
      repo.save(game);
    }

    // delete by ID
    @DeleteMapping(value="/games/{gameId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer gameId)  {
        repo.deleteById(gameId);
    }
}
