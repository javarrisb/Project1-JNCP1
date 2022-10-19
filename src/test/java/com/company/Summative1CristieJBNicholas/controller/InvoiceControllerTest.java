package com.company.Summative1CristieJBNicholas.controller;



import com.company.Summative1CristieJBNicholas.controller.InvoiceController;

import com.company.Summative1CristieJBNicholas.models.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    //    for our test
    private Invoice invoice1;
    private Invoice invoice2;


    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception {
//(int id, String name, String street, String city, String state, String zipcode)
        invoice1 = new Invoice(1, "Nicko", "Crystal","san antonio", "Texas", "78250");
        invoice2 = new Invoice(2, "Cleo","Crystal", "san antonio", "Texas", "78250");
    }
    @Test
    public void shouldCreateNewInvoice() throws Exception {
        String input = mapper.writeValueAsString(invoice1);

        mockMvc.perform(
                        post("/invoice")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(input));

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
