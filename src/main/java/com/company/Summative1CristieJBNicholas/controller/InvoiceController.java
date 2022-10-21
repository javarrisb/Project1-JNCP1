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
    private ServiceLayer serviceLayer;

//    private static int idCounter = 1;

 //   private static List<Invoice> invoiceList = new ArrayList<>(Arrays.asList(

//            new Invoice(idCounter++, "Billy Bob", "InADitch street", "San Antonio", "TX",
//                    "78211", 10, "shirt", 10.00, 1, 4.00, 8.75, 14.40),
//
//            new Invoice(idCounter++, "Billy Joe", "DownByTheRiver street", "San Antonio", "TX",
//                    "78201", 10, "shirt", 10.00, 1, 4.00, 8.75, 14.40)
//    ));

    // Create, Read and Read All operations
    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> findAllInvoices() {
        return serviceLayer.findAllInvoices();
    }

    /**
     * changed to service layer
     */
//    public List<Invoice> findAllInvoices(@RequestParam(required = false) String name, @RequestParam(required = false) String zipcode) {
//        List<Invoice> returnList = invoiceList;
//
//        if (name != null) {
//            returnList = invoiceList.stream()
//                    .filter(i -> i.getName().contains(name))
//                    .collect(Collectors.toList());
//        }
//        if (zipcode != null) {
//           returnList = returnList.stream()
//                .filter(i -> i.getZipcode().equals(zipcode))
//                .collect(Collectors.toList());
//    }
////        return returnList;
//        return serviceLayer.findAll();
//}
    @PostMapping(value = "/invoice")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createANewInvoice(@RequestBody @Valid Invoice invoice) throws QueryNotFoundException {
//        invoice.setId(idCounter++);
//        createANewInvoice().add(invoice);
        if (TaxServiceLayer.findSalesTaxRateByState(invoice.getState()) == null) {
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
    @GetMapping(value = "/invoice/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public Invoice findInvoiceById(@PathVariable Integer id) {
        Optional<Invoice> foundInvoice = InvoiceRepository.findById(id);
//
//        for(Invoice invoice : invoice) {
//            if(Objects.equals(invoice.getId(), id)) {
//                foundInvoice = invoice;
//                break;
//            }
        if (foundInvoice.isPresent()) {
            return foundInvoice.get();
        }else{
           throw new NotFoundException("Invoice not found in database.");
        }
    }
}