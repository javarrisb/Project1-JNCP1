package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.exception.QueryNotFoundException;
import com.company.Summative1CristieJBNicholas.models.Invoice;
import com.company.Summative1CristieJBNicholas.repository.InvoiceRepository;
import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import com.company.Summative1CristieJBNicholas.services.TaxServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.company.Summative1CristieJBNicholas.exception.NotFoundException;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
     ServiceLayer serviceLayer;
    @Autowired
    TaxServiceLayer taxServiceLayer;

    @Autowired
    InvoiceRepository invoiceRepository;
//    private static int idCounter = 1;

    // Create, Read and Read All operations
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> findAllInvoices() {
        return serviceLayer.findAllInvoices();
    }

    /**
     * changed to service layer
     */
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createANewInvoice(@RequestBody @Valid Invoice invoice) throws QueryNotFoundException {
//        invoice.setId(idCounter++);
//        createANewInvoice().add(invoice);
        if (taxServiceLayer.findSalesTaxRateByState(invoice.getState()) == null) {
            throw new QueryNotFoundException(invoice.getState() + " is not a valid code.");
        }
//        not sure about quantities in stock or is it required, any issues if we dont have it?
//        if(invoice.getQuantity() > serviceLayer.getItemQuantity(invoice)){
//
//        }
        if (invoice.getQuantity() <= 0) {
            throw new IllegalArgumentException("1 item must be purchased.");
        }
        return serviceLayer.createInvoice(invoice);
    }

    //read an invoice
    @GetMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public Invoice findInvoiceById(@PathVariable Integer id) throws QueryNotFoundException {
        Optional<Invoice> foundInvoice = serviceLayer.findById(id);
//
//        for(Invoice invoice : invoice) {
//            if(Objects.equals(invoice.getId(), id)) {
//                foundInvoice = invoice;
//                break;
//            }
        return foundInvoice.orElse(null);
    }
}