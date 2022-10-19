//package com.company.Summative1CristieJBNicholas.controller;
//
//import static org.junit.Assert.*;
//
//import com.company.Summative1CristieJBNicholas.models.Console;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.junit.Assert.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ConsoleController.class)
//public class ConsoleControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//
//    @Test
//    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception {
//        // ARRANGE
//        Console inputConsole = new Console();
////        inputConsole.setConsoleId(1);
//        inputConsole.setModel("Playstation 5");
//        inputConsole.setManufacturer("Sony");
////        inputConsole.setMemoryAmount("16 GB");
////        inputConsole.setPrice(725.99);
////        inputConsole.setQuantity(100)
//;
//        // Convert Java Object to JSON.
//        String inputJson = mapper.writeValueAsString(inputConsole);
//
//        // ACT
//        mockMvc.perform(
//                        post("/consoles")                                // Perform the POST request.
//                                .content(inputJson)                               // Set the request body.
//                                .contentType(MediaType.APPLICATION_JSON)          // Tell the server it's in JSON format.
//                )
//                .andDo(print())                                           // Print results to console.
//                .andExpect(status().isUnprocessableEntity());             // ASSERT (status code is 422)
//    }

//}