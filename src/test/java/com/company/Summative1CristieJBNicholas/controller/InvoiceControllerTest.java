package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.*;
import com.company.Summative1CristieJBNicholas.repository.InvoiceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
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
//    private Invoice invoice1;
//    private Invoice invoice2;

    @MockBean
    private InvoiceRepository repo;
    ObjectMapper mapper = new ObjectMapper();

    //    @Before
//    public void setup() throws Exception {
////(int id, String name, String street, String city, String state, String zipcode)
////        invoice1 = new Invoice(1, "Nicko", "Crystal","san antonio", "Texas", "78250");
////        invoice2 = new Invoice(2, "Cleo","Crystal", "san antonio", "Texas", "78250");
//    }
    @Test
    public void createANewInvoice() throws Exception {

        // ARRANGE
        Invoice inputInvoice = new Invoice();
        inputInvoice.setName("William Shatner");
        inputInvoice.setStreet("River street");
        inputInvoice.setCity("Roswell");
        inputInvoice.setState("NM");
        inputInvoice.setZipcode("99999");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputInvoice);

        Invoice outputInvoice = new Invoice();
        outputInvoice.setId(1);
        outputInvoice.setName("William Shatner");
        outputInvoice.setStreet("River street");
        outputInvoice.setCity("Roswell");
        outputInvoice.setState("NM");
        outputInvoice.setZipcode("99999");
        outputInvoice.setItem_id(10);
        outputInvoice.setItem_type("shirt");
        outputInvoice.setUnit_price(10.00);
        outputInvoice.setQuantity(1);
        outputInvoice.setProcessing_fee(4.00);
        outputInvoice.setTax(8.75);
        outputInvoice.setTotal(14.40);

        String outputJson = mapper.writeValueAsString(outputInvoice);

        // ACT
        mockMvc.perform(
                        post("/invoices")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

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
