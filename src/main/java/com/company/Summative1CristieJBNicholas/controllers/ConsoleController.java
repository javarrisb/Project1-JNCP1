package com.company.Summative1CristieJBNicholas.controllers;

import com.company.Summative1CristieJBNicholas.models.Console;
import com.company.Summative1CristieJBNicholas.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConsoleController {
    @Autowired
    CustomerRepository repo;

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
    @GetMapping("/Console/{console_id}")
    public Console getConsoleById(@PathVariable Integer console_id) {
        Optional<Console> returnVal = repo.findById(console_id);
        return returnVal.get();
    }

    // find Console by Manufacturer
    @GetMapping("/Console/{manufacturer}")
    public Console getConsoleByManufacturer(@PathVariable String manufacturer) {
        Optional<Console> returnVal = repo.findByColor(manufacturer);
        return returnVal.get();
    }

    // update an existing Console record
    @PutMapping("/Console")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console manufacturer) {
        repo.save(manufacturer);
    }

    // delete an existing Console record
    @DeleteMapping("/Console/{console_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable Integer console_id) {
        repo.deleteById(console_id;
    }
}
