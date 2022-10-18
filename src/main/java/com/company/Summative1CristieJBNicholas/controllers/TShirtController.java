package com.company.Summative1CristieJBNicholas.controllers;

import com.company.Summative1CristieJBNicholas.models.TShirt;
import com.company.Summative1CristieJBNicholas.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class TShirtController {
    @Autowired
    CustomerRepository repo;

    // create a new tShirt
    @PostMapping("/TShirt")
    @ResponseStatus(HttpStatus.CREATED)

    public TShirt addTShirt(@RequestBody TShirt tShirt) {
        return repo.save(tShirt);
    }

    // find all TShirts; from rsvp-service classwork
    @RequestMapping(value = "/TShirt", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getAllTShirts() {
        System.out.println("Getting All T-Shirts");
        return repo.findAll();
    }
    // find TShirt by iD
    @GetMapping("/TShirt/{t_shirt_id}")
    public TShirt getTShirtById(@PathVariable Integer t_shirt_id) {
        Optional<TShirt> returnVal = repo.findById(t_shirt_id);
        return returnVal.get();
    }
    // find TShirt by Color
    @GetMapping("/TShirt/{color}")
    public TShirt getTShirtByColor(@PathVariable String color) {
        Optional<TShirt> returnVal = repo.findByColor(color);
        return returnVal.get();
    }

    // find TShirt by Size
    @GetMapping("/TShirt/{Size}")
    public TShirt getTShirtBySize(@PathVariable String size) {
        Optional<TShirt> returnVal = repo.findBySize(size);
        return returnVal.get();
    }

    // update an existing TShirt record
    @PutMapping("/TShirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody TShirt tShirt) {
        repo.save(tShirt);
    }

    // delete an existing TShirt record
    @DeleteMapping("/TShirt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable Integer t_shirt_id) {
        repo.deleteById(t_shirt_id);
    }

}
