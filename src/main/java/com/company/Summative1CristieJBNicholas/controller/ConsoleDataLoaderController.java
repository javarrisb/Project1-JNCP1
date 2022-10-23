package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Console;
import com.company.Summative1CristieJBNicholas.repository.ConsoleRepository;
import com.company.Summative1CristieJBNicholas.repository.GameRepository;
import com.company.Summative1CristieJBNicholas.services.ProcessingFeeServiceLayer;
import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import com.company.Summative1CristieJBNicholas.services.TaxServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsoleDataLoaderController {
    @Autowired
    ConsoleRepository repo;
    @Autowired
    ProcessingFeeServiceLayer processingFeeServiceLayer;
    @Autowired
    TaxServiceLayer taxServiceLayer;
    @Autowired
    ServiceLayer serviceLayer;


    @GetMapping("/load-console-data")
    @ResponseStatus(HttpStatus.CREATED)
      public void loadData() {
        serviceLayer.clearDatabase();
        taxServiceLayer.loadTaxRate();
        processingFeeServiceLayer.loadFee();

        Console console = new Console();
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("16 GB");
        console.setProcessor("Custom AMD RDNA 2");
        console.setPrice(725.99);
        console.setQuantity(100);
        repo.save(console);

        Console console1 = new Console();
        console1.setModel("Series X");
        console1.setManufacturer("Microsoft");
        console1.setMemoryAmount("16 GB");
        console1.setProcessor("Custom AMD RDNA 2");
        console1.setPrice(619.99);
        console1.setQuantity(100);
        repo.save(console1);

        Console console2 = new Console();
        console2.setModel("Switch");
        console2.setManufacturer("Nintendo");
        console2.setMemoryAmount("4 GB");
        console2.setProcessor("ARM 4 Cortex-A57");
        console2.setPrice(349.99);
        console2.setQuantity(100);
        repo.save(console2);

        Console console3 = new Console();
        console3.setModel("Chromecast");
        console3.setManufacturer("Google");
        console3.setMemoryAmount("2 GB");
        console3.setProcessor("Amlogic S905X3");
        console3.setPrice(49.99);
        console3.setQuantity(100);
        repo.save(console3);
    }
}
