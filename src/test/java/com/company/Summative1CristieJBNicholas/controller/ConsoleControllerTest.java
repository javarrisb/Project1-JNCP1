package com.company.Summative1CristieJBNicholas.controller;

import static org.junit.Assert.*;

import com.company.Summative1CristieJBNicholas.models.Console;
import com.company.Summative1CristieJBNicholas.repository.ConsoleRepository;
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
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)

public class ConsoleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsoleRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private Console gameStoreConsole;

    private String gameStoreJson;

    private List<Console> allConsoles = new ArrayList<>();

    private String allConsolesJson;


    @Before
    public void setup() throws Exception {
        gameStoreConsole = new Console();
        gameStoreConsole.setConsoleId(1);
        gameStoreConsole.setManufacturer("Sony");
        gameStoreConsole.setMemoryAmount("16GB");
        gameStoreConsole.setProcessor("Custom AMD RDNA 2");
        gameStoreConsole.setPrice(725.99);
        gameStoreConsole.setQuantity(100);

        gameStoreJson = mapper.writeValueAsString(gameStoreConsole);

        Console console = new Console();
        console.setConsoleId(1);
        console.setManufacturer("Sony");
        console.setMemoryAmount("16GB");
        console.setProcessor("Custom AMD RDNA 2");
        console.setPrice(725.99);
        console.setQuantity(100);


        allConsoles.add(gameStoreConsole);
        allConsoles.add(console);

        allConsolesJson = mapper.writeValueAsString(allConsoles);

    }

    //from work done with RSVP-Service
    @Test
    public void shouldCreateNewConsoleOnPostRequest() throws Exception {
        Console inputConsole = new Console();
        inputConsole.setConsoleId(1);
        inputConsole.setManufacturer("Sony");
        inputConsole.setMemoryAmount("16GB");
        inputConsole.setProcessor("Custom AMD RDNA 2");
        inputConsole.setPrice(725.99);
        inputConsole.setQuantity(100);

        String inputJson = mapper.writeValueAsString(inputConsole);
        doReturn(gameStoreConsole).when(repo).save(inputConsole);

        mockMvc.perform(
                        post("/Console")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(gameStoreJson));

    }

    @Test
    public void shouldReturnConsoleById() throws Exception {
        doReturn(Optional.of(gameStoreConsole)).when(repo).findById(1);

        ResultActions result = mockMvc.perform(
                        get("/Console/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(gameStoreJson))
                );
    }
//    @Test
//    public void shouldReturnConsoleOnValidGetRequest() throws Exception {
//        String gameStoreJson = "Sony";
//
//        mockMvc.perform(
//                        get("/Console/manufacturer/Sony")
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(gameStoreJson)
//                );
//    }
//


    @Test
    public void shouldReturnAllConsoles() throws Exception {
        doReturn(allConsoles).when(repo).findAll();

        mockMvc.perform(
                        get("/Console"))
                .andExpect(status().isOk())
                .andExpect(content().json(allConsolesJson)
                );
    }


//        @Test
//    public void shouldUpdateByIdAndReturn200StatusCode() throws Exception {
////            Console inputConsole = new Console();
////            inputConsole.setConsoleId(1);
////
////
////            String inputJson = mapper.writeValueAsString(inputConsole);
////            doReturn(gameStoreConsole).when(repo).save(inputConsole);
//
//        mockMvc.perform(
//                        put("/Consoles/1")
//                                .content(gameStoreJson)
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isOk());
    }

//    @Test
//    public void shouldDeleteByIdAndReturn200StatusCode() throws Exception {
//        mockMvc.perform(delete("/Console/2")).andExpect(status().isOk());
//    }

//}