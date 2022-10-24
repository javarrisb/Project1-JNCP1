//package com.company.Summative1CristieJBNicholas.controller;
//
//
//import com.company.Summative1CristieJBNicholas.models.Console;
//import com.company.Summative1CristieJBNicholas.models.Games;
//import com.company.Summative1CristieJBNicholas.models.TShirt;
//import com.company.Summative1CristieJBNicholas.services.ProcessingFeeServiceLayer;
//import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
//import com.company.Summative1CristieJBNicholas.services.TaxServiceLayer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LoadDataController {
//
//    @Autowired
//    ServiceLayer serviceLayer;
//
//    @Autowired
//    TaxServiceLayer taxServiceLayer;
//
//    @Autowired
//    ProcessingFeeServiceLayer processingFeeLayer;
//
//    @PostMapping("/loadDataController")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void seedData(){
//        serviceLayer.clearDatabase();
//        taxServiceLayer.loadTaxRate();
//        processingFeeLayer.loadFee();
////
//        serviceLayer.addGame(new Games( 1, "Minecraft", "E(Everyone",
//                "A 3D sandbox game that allows players a large amount of freedom in choosing how to play the game.",
//        19.99,"Mojang",100));
//        serviceLayer.addGame(new Games(2, "Tetris","NR",
//                "Players must rotate, move, and drop the falling Tetriminos inside the Matrix", 1.59,
//        "Spectrum HoloByte", 50));
//        serviceLayer.addGame(new Games (3, "Grand Theft Auto V", "Mature", "Single player story follows three" +
//                " protagonists and their attempts to commit heists while under pressure from a corrupt" +
//                " government agency and powerful criminals.", 59.99, "Rockstar North", 250));
//        serviceLayer.addGame(new Games(4, "NBA 2K23", "Everyone", "A player interactive game based on the NBA that" +
//                " allows you to play as NBA teams as well as create your own player.", 70.00, "2K", 75));
//
//        serviceLayer.addConsole(new Console(1, "PS-5", "Sony", "16 GB", "Custom AMD RDNA 2", 725.99, 100));
//        serviceLayer.addConsole(new Console(2, "Series X", "Microsoft", "16 GB", "Custom AMD RDNA 2", 619.99, 100));
//        serviceLayer.addConsole(new Console(3, "Switch", "Nintendo", "4 GB", "ARM 4 Cortex-A57", 349.99, 100));
//        serviceLayer.addConsole(new Console(4, "Chromecast", "Google", "2 GB", "Amlogic S905X3", 49.99, 100));
//
//        serviceLayer.addTshirt(new TShirt(1,"X-Small", "Blue", "GameStorePromo", 10.99, 20 ));
//       serviceLayer.addTshirt(new TShirt(2,"Small", "Blue", "GameStorePromo", 10.99, 20));
//        serviceLayer.addTshirt(new TShirt(3, "Medium", "Blue", "GameStorePromo", 10.99, 20));
//        serviceLayer.addTshirt(new TShirt(4,"Large", "Blue", "GameStorePromo", 10.99, 20));
//        serviceLayer.addTshirt(new TShirt(5,"X-Large", "Blue", "GameStorePromo", 10.99, 20));
//        serviceLayer.addTshirt(new TShirt(6,"XX-Large", "Blue", "GameStorePromo", 10.99, 20));
//    }
//}
//
