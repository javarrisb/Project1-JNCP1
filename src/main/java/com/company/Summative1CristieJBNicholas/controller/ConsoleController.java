package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Console;
import com.company.Summative1CristieJBNicholas.repository.ConsoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // find Console by iD
    @GetMapping("/Console/consoleId/{consoleId}")
    public Console getConsoleById(@PathVariable Integer consoleId) {
        Optional<Console> returnVal = repo.findById(consoleId);
        return returnVal.get();
    }

    // find Console by Manufacturer
    @GetMapping("/Console/manufacturer/{manufacturer}")
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {
        return repo.findAllConsolesByManufacturer(manufacturer);
    }

   // update an existing Console record
//    @PutMapping("/Console/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void updateConsole(@RequestBody Console console) {
//        repo.save(console);
//    }

    // delete an existing Console record
    @DeleteMapping("/Console/{consoleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable Integer consoleId) {
        repo.deleteById(consoleId);
    }
}
