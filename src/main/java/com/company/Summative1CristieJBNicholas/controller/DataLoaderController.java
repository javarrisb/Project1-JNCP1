package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Games;
import com.company.Summative1CristieJBNicholas.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataLoaderController {

    @Autowired
    GameRepository repo;

    @GetMapping("/load-data")
    public void loadData() {
        Games game = new Games();
        game.setTitle("Minecraft");
        game.setEsrb_rating("Everyone10+");
        game.setDescription("A 3D sandbox game that allows players a large amount of freedom in choosing how to play the game.");
        game.setPrice(19.99);
        game.setStudio("Mojang");
        game.setQuantity(100);
        repo.save(game);

        Games game1 = new Games();
        game1.setTitle("Tetris");
        game1.setEsrb_rating("Not Rated");
        game1.setDescription("Players must rotate, move, and drop the falling Tetriminos inside the Matrix");
        game1.setPrice(1.59);
        game1.setStudio("Spectrum HoloByte");
        game1.setQuantity(50);
        repo.save(game1);

        Games game2 = new Games();
        game2.setTitle("Grand Theft Auto V");
        game2.setEsrb_rating("Mature");
        game2.setDescription("Single player story follows three protagonists and their attempts to commit heists while under pressure from a corrupt government agency and powerful criminals.");
        
    }
}
