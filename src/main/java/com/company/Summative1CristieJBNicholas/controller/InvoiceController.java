package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.company.Summative1CristieJBNicholas.exception.NotFoundException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    private static int idCounter = 1;

    private static List<Invoice> invoiceList = new ArrayList<>(Arrays.asList(

            new Invoice(idCounter++,"Billy Bob", "InADitch street", "San Antonio", "TX",
                    "78211", 10, "shirt", 10.00, 1, 4.00, 8.75, 14.40 ),

             new Invoice(idCounter++,"Billy Joe", "DownByTheRiver street", "San Antonio", "TX",
            "78201", 10, "shirt", 10.00, 1, 4.00, 8.75, 14.40 )
           ));

    // Create, Read and Read All operations
    @PostMapping(value = "/invoice")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createANewInvoice(@RequestBody @Valid Invoice invoice) {
        invoice.setId(idCounter++);
        invoiceList.add(invoice);

        return invoice;
    }

//read an invoice
    @GetMapping(value = "/invoice/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Invoice> findInvoiceById (@PathVariable int id) {
        Invoice foundInvoice = null;

        for(Invoice invoice : invoiceList) {
            if(invoice.getId() == id) {
                foundInvoice = invoice;
                break;
            }
        }
        if (foundInvoice == null) {
            throw new NotFoundException("Record not found in collection");
        }
        return Optional.of(foundInvoice);
    }

    @GetMapping(value = "/invoices")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoices(@RequestParam(required = false) String name, @RequestParam(required = false) String zipcode) {
    List<Invoice> returnList = invoiceList;

    if (name != null) {
        returnList = invoiceList.stream()
                .filter(r -> r.getName().contains(name))
                .collect(Collectors.toList());
    }

    if (name != null) {
        returnList = returnList.stream()
                .filter( r -> r.getName().equals(name))
                .collect(Collectors.toList());
    }

    return returnList;
}
}
