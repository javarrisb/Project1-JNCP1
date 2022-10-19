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


    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoices() {
        return serviceLayer.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createANewInvoice(@RequestBody Invoice invoice) {

        return serviceLayer.createInvoice(invoice);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody Invoice invoice) {

        serviceLayer.updateInvoice(invoice);
    }

   @DeleteMapping(value = "/invoice{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoiceById(@PathVariable Integer id) {
        serviceLayer.deleteInvoiceById(id);
    }
    @GetMapping(value = "/invoice{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Invoice> findCustomerById (@PathVariable int id) {
        return serviceLayer.findByID(id);
    }


}
