package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.*;
import com.company.Summative1CristieJBNicholas.repository.InvoiceRepository;
import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
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
import java.util.List;

import static org.mockito.Mockito.doReturn;
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
    private ObjectMapper mapper = new ObjectMapper();

    private Invoice customerInvoice;
    private String inputJson;
    private String outputJson;

    private List<Invoice> allInvoices = new ArrayList<>();
    private String allInvoicesJson;

    @Before
    public void setup() throws Exception {
       customerInvoice = new Invoice();
        customerInvoice.setName("William");
        customerInvoice.setStreet("River Street");
        customerInvoice.setCity("Roswell");
        customerInvoice.setState("NM");
        customerInvoice.setZipcode("99999");


        inputJson = mapper.writeValueAsString(customerInvoice);

        //output
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setName("William");
        invoice.setStreet("River Street");
        invoice.setCity("Roswell");
        invoice.setState("NM");
        invoice.setZipcode("99999");
        invoice.setItem_id(10);
        invoice.setItem_type("shirt");
        invoice.setUnit_price(10.00);
        invoice.setQuantity(1);
        invoice.setProcessing_fee(3.00);
        invoice.setTax(8.75);
        invoice.setTotal(14.40);

        allInvoices.add(invoice);
        allInvoicesJson = mapper.writeValueAsString(allInvoices);

//        doReturn(outputAlbumViewModel).when(serviceLayer).saveAlbum(inputAlbumViewModel);
//        doReturn(outputAlbumViewModel).when(serviceLayer).findAlbum(89);
    }
//    public void setup() throws Exception {
//        Invoice invoice1 = new Invoice(1, "William Shatner", "River street", "Roswell", "NM",
//        "99999", 10, "shirt", 10.00,1, 4.00, 8.75,14.40);

    @Test
    public void createANewInvoice() throws Exception {
        Invoice inputInvoice = new Invoice();
        inputInvoice.setId(1);
        inputInvoice.setName("William");
        inputInvoice.setStreet("River Street");
        inputInvoice.setUnit_price(10.00);
        inputInvoice.setQuantity(1);

        String inputJson = mapper.writeValueAsString(inputInvoice);
        doReturn(customerInvoice).when(serviceLayer).repo(inputInvoice);

        mockMvc.perform(
                        post("/invoice")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }
    @Test
    public void shouldReturnAllInvoices() throws Exception {
        doReturn(allInvoices).when(serviceLayer).findAll();
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
