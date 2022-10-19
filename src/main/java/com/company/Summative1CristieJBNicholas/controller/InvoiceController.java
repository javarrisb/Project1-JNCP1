package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Invoice;
import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    private ServiceLayer serviceLayer;

// Create, Read and Read All operations
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createANewInvoice(@RequestBody Invoice invoice) {
        return serviceLayer.createInvoice(invoice);
    }

//read an invoice
    @GetMapping(value = "/invoice{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Invoice> findInvoiceById (@PathVariable int id) {
        return serviceLayer.findByID(id);
    }
//read all invoices
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> readAllInvoices() {
        return serviceLayer.findAll();
    }
}
