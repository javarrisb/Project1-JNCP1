package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.exception.QueryNotFoundException;
import com.company.Summative1CristieJBNicholas.models.*;
import com.company.Summative1CristieJBNicholas.repository.InvoiceRepository;
import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import com.company.Summative1CristieJBNicholas.services.TaxServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServiceLayer serviceLayer;
    @MockBean
    TaxServiceLayer taxServiceLayer;
    private ObjectMapper mapper = new ObjectMapper();

    Invoice customerInvoice;

    Invoice invoice1;
    Invoice invoice2;

    String inputJson;
    String outputJson;
    List<Invoice> allInvoices;
    String allInvoicesJson;

    @Before
    public void setup() throws QueryNotFoundException {
       serviceLayer.clearDatabase();
       setUpInvoiceMocks();
    }
//Integer id, String name, String street, String city, String state, String zipcode,
//                   Integer item_id, String item_type, double unit_price, int quantity, double subtotal,
//                   double processing_fee, double tax, double total)
    private void setUpInvoiceMocks() throws QueryNotFoundException {
        invoice1 = new Invoice(1, "William Shatner", "DownByTheRiver St.", "Roswell", "NM",
                "99999", 123, "console", 19.99, 2, 39.98,
                0.00, 0.05,48.98 );
        invoice2 = new Invoice(1, "Billy Bob", "InAVan St.", "Roswell", "NM",
                "98939", 123, "console", 19.99, 2, 39.98,
                0.00, 0.05,48.98 );

        customerInvoice = new Invoice(1,"William Shatner", "DownByTheRiver St.", "Roswell",
                "NM", "99999", 123, "console", 19.99, 2, 39.98);

        allInvoices = Arrays.asList(invoice1, invoice2);

         TaxRate salesTaxRate = new  TaxRate("NM",0.03);
        when(serviceLayer.findAllInvoices()).thenReturn(allInvoices);
        when(serviceLayer.findById(1)).thenReturn(Optional.of(invoice1));
        when(serviceLayer.createInvoice(customerInvoice)).thenReturn(invoice1);


        when(TaxServiceLayer.findSalesTaxRateByState("NM")).thenReturn(salesTaxRate);
        when(TaxServiceLayer.findSalesTaxRateByState("Not a state code!")).thenReturn(null);
        when(serviceLayer.applyProcessingFee(customerInvoice)).thenReturn(1.49);
        when(serviceLayer.getItemQuantity(customerInvoice)).thenReturn(40);
    }

    @Test
    public void shouldReturnNewInvoiceWithStatus201() throws Exception {

        inputJson = mapper.writeValueAsString(customerInvoice);
        outputJson = mapper.writeValueAsString(invoice1);
        mockMvc.perform(
                        post("/invoice")
                                .content(String.valueOf(customerInvoice))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }
    @Test
    public void shouldReturnAllInvoices() throws Exception {
        doReturn(allInvoices).when(serviceLayer).findAllInvoices();
        mockMvc.perform(
                get("/invoices"))
                .andExpect(status().isOk())
                .andExpect(content().json(allInvoicesJson));
//        mockMvc.perform(get("/invoices"))
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$[0]").isNotEmpty())
//            .andExpect(jsonPath("$[0].name").isNotEmpty())
//            .andExpect(jsonPath("$[0].street").isNotEmpty())
//            .andExpect(jsonPath("$[0].id").isNotEmpty());
}


    @Test
    public void shouldReturnInvoiceById() throws Exception {
        String input = mapper.writeValueAsString("/invoice/5");

        mockMvc.perform(
                        get("/invoice/5")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(input));
    }

}
