package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.exception.ProductNotFoundException;

import com.company.Summative1CristieJBNicholas.models.TShirt;
import com.company.Summative1CristieJBNicholas.repository.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class TShirtController {
    @Autowired
    TShirtRepository repo;

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
    // find TShirt by iD; ; throws 422 error if invalid ID is selected
    @GetMapping("/TShirt/{tShirtId}")
    public TShirt getTShirtById(@PathVariable Integer tShirtId) {
        // from echo-range-service class work
        if (tShirtId < 1) {
            throw new IllegalArgumentException("T-Shirt ID must be at least 1");
        }
        Optional<TShirt> returnVal = repo.findById(tShirtId);
        if (returnVal.isPresent()){
            return returnVal.get();
        } else {
            throw new ProductNotFoundException("No such console. id:  " + tShirtId);
        }
    }

    // find TShirt by Color
    @GetMapping("/TShirt/color/{color}")
    public List<TShirt> getTShirtByColor(@PathVariable String color) {
        return repo.findByColor(color);
    }

    // find TShirt by Size
    @GetMapping("/TShirt/size/{size}")
    public List<TShirt> getTShirtBySize(@PathVariable String size) {
        return repo.findBySize(size);
    }

    // update an existing TShirt record

    @PutMapping("/TShirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody TShirt tShirt, @PathVariable Integer tShirtId) {
        repo.save(tShirt);
    }

    // delete an existing TShirt record
    @DeleteMapping("/TShirt/{tShirtId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable Integer tShirtId) {
        if (tShirtId < 1) {
            throw new IllegalArgumentException("Cannot delete a T-Shirt unless T-Shirt ID is at least 1");
        }
        repo.deleteById(tShirtId);
    }
}