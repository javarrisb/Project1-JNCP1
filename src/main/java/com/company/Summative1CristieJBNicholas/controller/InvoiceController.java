//package com.company.Summative1CristieJBNicholas.controller;
//
//import com.company.Summative1CristieJBNicholas.exception.QueryNotFoundException;
//import com.company.Summative1CristieJBNicholas.models.Invoice;
////import com.company.Summative1CristieJBNicholas.repository.InvoiceRepository;
////import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
//import com.company.Summative1CristieJBNicholas.services.TaxServiceLayer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//
//import javax.validation.Valid;
//import java.util.*;
//import java.util.stream.Collectors;
//
//
//@RestController
////@RequestMapping(value = "/invoice")
//public class InvoiceController {
//
//    @Autowired
//    ServiceLayer serviceLayer;
//    @Autowired
//    TaxServiceLayer taxServiceLayer;
//
//    @Autowired
//    InvoiceRepository invoiceRepository;
////    private static int idCounter = 1;
//
//    // Create, Read and Read All operations
//    @GetMapping(value = "/invoices/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Invoice> findAllInvoices() {
//        return serviceLayer.findAllInvoices();
//    }
//    /**
//     * changed to service layer
//     */
//    @PostMapping(value = "/invoice/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Invoice createANewInvoice(@RequestBody @Valid Invoice invoice) throws QueryNotFoundException {
//        if (taxServiceLayer.findSalesTaxRateByState(invoice.getState()) == null) {
//            throw new QueryNotFoundException(invoice.getState() + " is not a valid code.");
//        }
//        if (invoice.getQuantity() <= 0) {
//            throw new IllegalArgumentException("1 item must be purchased.");
//        }
//        return serviceLayer.createInvoice(invoice);
//    }
//
//    //read an invoice
//    @GetMapping(value = "/invoice/{id}")
////    @ResponseStatus(HttpStatus.OK)
//    public Optional <Invoice> findInvoiceById(@PathVariable Integer id) throws QueryNotFoundException {
//        if(serviceLayer.findById(id).orElse(null) == null){
//            throw new QueryNotFoundException("Invoice does not exist with that ID.");
//        }
//        return serviceLayer.findById(id);
//    }
//}