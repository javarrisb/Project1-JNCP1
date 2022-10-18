package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Console;
import com.company.Summative1CristieJBNicholas.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsoleDataLoaderController {
    @Autowired
    ConsoleRepository repo;

    @GetMapping("/load-data")

    public void loadData() {
        Console console = new Console();
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("16 GB");
        console.setProcessor("Custom AMD RDNA 2");
        console.setPrice(725.99);
        console.setQuantity(100);
        repo.save(console);

        Console console1 = new Console();
        console1.setModel("Series X");
        console1.setManufacturer("Microsoft");
        console1.setMemory_amount("16 GB");
        console1.setProcessor("Custom AMD RDNA 2");
        console1.setPrice(619.99);
        console1.setQuantity(100);
        repo.save(console1);

        Console console2 = new Console();
        console2.setModel("Switch");
        console2.setManufacturer("Nintendo");
        console2.setMemory_amount("4 GB");
        console2.setProcessor("ARM 4 Cortex-A57");
        console2.setPrice(349.99);
        console2.setQuantity(100);
        repo.save(console2);

        Console console3 = new Console();
        console3.setModel("Chromecast");
        console3.setManufacturer("Google");
        console3.setMemory_amount("2 GB");
        console3.setProcessor("Amlogic S905X3");
        console3.setPrice(49.99);
        console3.setQuantity(100);
        repo.save(console3);
    }
}
