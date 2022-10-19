package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import com.company.Summative1CristieJBNicholas.exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

//    @Autowired
//    private ServiceLayer serviceLayer;

    private static int idCounter = 1;

//(int id, String name, String street, String city, String state, String zipcode)
    private static List<Invoice> invoiceList = new ArrayList<>(Arrays.asList(
            new Invoice( idCounter++,"William Shatner", "River street", "Roswell", "NM", "12345" ),
            new Invoice(idCounter++,"Billy Bob", "InADitch street", "San Antonio", "TX", "78211" )
           ));

    // Create, Read and Read All operations
    @RequestMapping(value = "/invoice",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createANewInvoice(@RequestBody Invoice invoice) {
        invoice.setId(idCounter++);
        invoiceList.add(invoice);
        return invoice;
    }

//read an invoice
//    @GetMapping(value = "/invoice/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Optional<Invoice> findInvoiceById (@PathVariable int id) {
//        Invoice foundInvoice = null;
//
//        for(Invoice invoice : invoiceList) {
//            if(invoice.getId() == id) {
//                foundInvoice = invoice;
//                break;
//            }
//        }
//        if (foundInvoice == null) {
//            throw new NotFoundException("Record not found in collection");
//        }
//        return foundInvoice;
//    }
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
