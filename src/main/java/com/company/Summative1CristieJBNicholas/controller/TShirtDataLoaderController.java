package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.TShirt;
import com.company.Summative1CristieJBNicholas.repository.ConsoleRepository;
import com.company.Summative1CristieJBNicholas.repository.TShirtRepository;
import com.company.Summative1CristieJBNicholas.services.ProcessingFeeServiceLayer;
import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import com.company.Summative1CristieJBNicholas.services.TaxServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TShirtDataLoaderController {

    @Autowired
    ProcessingFeeServiceLayer processingFeeServiceLayer;
    @Autowired
    TaxServiceLayer taxServiceLayer;
    @Autowired
    ServiceLayer serviceLayer;
    @Autowired
    TShirtRepository repo;

    @GetMapping("/load-tshirt-data")
    public void loadData() {
        serviceLayer.clearDatabase();
        taxServiceLayer.loadTaxRate();
        processingFeeServiceLayer.loadFee();

        TShirt tShirt  = new TShirt();
        tShirt.setSize("X-Small");
        tShirt.setColor("Blue");
        tShirt.setDescription("GameStorePromo");
        tShirt.setPrice(10.99);
        tShirt.setQuantity(20);
        repo.save(tShirt);

        TShirt tShirt1  = new TShirt();
        tShirt1.setSize("Small");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("GameStorePromo");
        tShirt1.setPrice(10.99);
        tShirt1.setQuantity(20);
        repo.save(tShirt1);

        TShirt tShirt2  = new TShirt();
        tShirt2.setSize("Medium");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("GameStorePromo");
        tShirt2.setPrice(10.99);
        tShirt2.setQuantity(20);
        repo.save(tShirt2);

        TShirt tShirt3  = new TShirt();
        tShirt3.setSize("Large");
        tShirt3.setColor("Blue");
        tShirt3.setDescription("GameStorePromo");
        tShirt3.setPrice(10.99);
        tShirt3.setQuantity(20);
        repo.save(tShirt3);

        TShirt tShirt4  = new TShirt();
        tShirt4.setSize("X-Large");
        tShirt4.setColor("Blue");
        tShirt4.setDescription("GameStorePromo");
        tShirt4.setPrice(10.99);
        tShirt4.setQuantity(20);
        repo.save(tShirt4);

        TShirt tShirt5  = new TShirt();
        tShirt5.setSize("XX-Large");
        tShirt5.setColor("Blue");
        tShirt5.setDescription("GameStorePromo");
        tShirt5.setPrice(10.99);
        tShirt5.setQuantity(20);
        repo.save(tShirt5);

    }
}
