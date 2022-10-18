package com.company.Summative1CristieJBNicholas.controllers;

import com.company.Summative1CristieJBNicholas.models.TShirt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController

public class TShirtController {
    @Autowired
//    CustomerRepository repo;

    // create a new Tshirt
    @PostMapping("/TShirt")
    @ResponseStatus(HttpStatus.CREATED)

    public TShirt addTShirt(@RequestBody TShirt tShirt) {
        return repo.save(tShirt);
    }

    @GetMapping("/Tshirt/{id}")
    public TShirt getTShirtById(@PathVariable Integer id) {
        Optional
    }


}
