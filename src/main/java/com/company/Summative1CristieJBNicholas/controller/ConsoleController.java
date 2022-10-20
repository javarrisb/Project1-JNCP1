package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.exception.ProductNotFoundException;
import com.company.Summative1CristieJBNicholas.models.Console;
import com.company.Summative1CristieJBNicholas.repository.ConsoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


// using JSR 303 annotations to validate inputs

// create a global error handler for all exceptions thrown by controller methods
@RestController
public class ConsoleController {
    @Autowired
    ConsoleRepository repo;

    // create a new Console
    @PostMapping("/Console")
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsole(@RequestBody Console console) {
        return repo.save(console);
    }

    // find all Consoles; from rsvp-service classwork
    @RequestMapping(value = "/Console", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsoles() {
        System.out.println("Getting All Consoles");
        return repo.findAll();
    }

    // find Console by iD; throws 422 error if invalid ID is selected
    @GetMapping("/Console/{consoleId}")
    public Console getConsoleById(@PathVariable Integer consoleId) {
        if (consoleId < 1) {
            throw new IllegalArgumentException("Console ID must be at least 1");
        }
        Optional<Console> returnVal = repo.findById(consoleId);
        if (returnVal.isPresent()){
            return returnVal.get();
        } else {
            throw new ProductNotFoundException("No such console. id:  " + consoleId);
        }
    }

    // find Console by Manufacturer
    @GetMapping("/Console/manufacturer/{manufacturer}")
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {
        return repo.findAllConsolesByManufacturer(manufacturer);
    }


    // update an existing Console record
    @PutMapping(value = "/Console")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console) {
        repo.save(console);
    }

    // delete an existing Console record
    @DeleteMapping("/Console/{consoleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable Integer consoleId) {
        if (consoleId < 1) {
            throw new IllegalArgumentException("Cannot delete a Console unless Console ID is at least 1");
        }
        repo.deleteById(consoleId);
    }
}
