package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Games;
import com.company.Summative1CristieJBNicholas.repository.GameRepository;
//import com.company.Summative1CristieJBNicholas.services.ProcessingFeeServiceLayer;
//import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import com.company.Summative1CristieJBNicholas.services.TaxServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameDataLoaderController {

//    @Autowired
//    ProcessingFeeServiceLayer processingFeeServiceLayer;
    @Autowired
    TaxServiceLayer taxServiceLayer;
//    @Autowired
//    ServiceLayer serviceLayer;
    @Autowired
    GameRepository repo;

    @GetMapping("/load-game-data")
//    @ResponseStatus(HttpStatus.CREATED)
    public void loadData() {
//        serviceLayer.clearDatabase();
        taxServiceLayer.loadTaxRate();
//        processingFeeServiceLayer.loadFee();

        Games game = new Games();
        game.setTitle("Minecraft");
        game.setEsrbRating("Ten+");
        game.setDescription("A 3D sandbox game that allows players a large amount of freedom in choosing how to play the game.");
        game.setPrice(19.99);
        game.setStudio("Mojang");
        game.setQuantity(100);
        repo.save(game);

        Games game1 = new Games();
        game1.setTitle("Tetris");
        game1.setEsrbRating("NR");
        game1.setDescription("Players must rotate, move, and drop the falling Tetriminos inside the Matrix");
        game1.setPrice(1.59);
        game1.setStudio("Spectrum HoloByte");
        game1.setQuantity(50);
        repo.save(game1);

        Games game2 = new Games();
        game2.setTitle("Grand Theft Auto V");
        game2.setEsrbRating("Mature");
        game2.setDescription("Single player story follows three protagonists and their attempts to commit heists while under pressure from a corrupt government agency and powerful criminals.");
        game2.setPrice(59.99);
        game2.setStudio("Rockstar North");
        game2.setQuantity(250);
        repo.save(game2);

        Games game3 = new Games();
        game3.setTitle("Wii Sports");
        game3.setEsrbRating("Child");
        game3.setDescription("A collection of five sports games (tennis, baseball, bowling, golf and boxing) designed to demonstrate the motion-sensing capabilities");
        game3.setPrice(35.99);
        game3.setStudio("Nintendo");
        game3.setQuantity(10);
        repo.save(game3);

        Games game4 = new Games();
        game4.setTitle("NBA 2K23");
        game4.setEsrbRating("Everyone");
        game4.setDescription("A player interactive game based on the NBA that allows you to play as NBA teams as well as create your own player.");
        game4.setPrice(70.00);
        game4.setStudio("2K");
        game4.setQuantity(75);
        repo.save(game4);

    }
}
