package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.TShirt;
import com.company.Summative1CristieJBNicholas.repository.TShirtRepository;
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

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)


public class TShirtControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TShirtRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private TShirt gameStoreTShirt;

    private String tShirtJson;

    private List<TShirt> allTShirts = new ArrayList<>();

    private String allTShirtsJson;

    @Before
    public void setUp() throws Exception {
        // input
        gameStoreTShirt = new TShirt();
        gameStoreTShirt.setSize("X-Small");
        gameStoreTShirt.setColor("Blue");
        gameStoreTShirt.setDescription("GameStorePromo");
        gameStoreTShirt.setPrice(10.99);
        gameStoreTShirt.setQuantity(20);

        tShirtJson = mapper.writeValueAsString(gameStoreTShirt);

        // output
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(1);
        tShirt.setSize("X-Small");
        tShirt.setColor("Blue");
        tShirt.setDescription("GameStorePromo");
        tShirt.setPrice(10.99);
        tShirt.setQuantity(20);

        allTShirts.add(tShirt);

        allTShirtsJson = mapper.writeValueAsString(allTShirts);
    }

    //from work done with RSVP-Service
    @Test
    public void shouldCreateNewConsoleOnPostRequest() throws Exception {
        TShirt inputTShirt = new TShirt();
        inputTShirt.settShirtId(1);
        inputTShirt.setSize("X-Small");
        inputTShirt.setColor("Blue");
        inputTShirt.setDescription("GameStorePromo");
        inputTShirt.setPrice(10.99);
        inputTShirt.setQuantity(20);

        String inputJson = mapper.writeValueAsString(inputTShirt);
        doReturn(gameStoreTShirt).when(repo).save(inputTShirt);

        mockMvc.perform(
                        post("/TShirt")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(tShirtJson));

    }

    @Test
    public void shouldReturnTShirtById() throws Exception {
        doReturn(Optional.of(gameStoreTShirt)).when(repo).findById(1);

        ResultActions result = mockMvc.perform(
                        get("/TShirt/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(tShirtJson))
                );
    }

    // works but does not test to see if status is ok *****
//    @Test
//    public void shouldBeStatusOkForNonExistentTShirtId() throws Exception {
//        ResultActions result = null;
//        doReturn(Optional.empty()).when(repo).findById(1234);
//        mockMvc.perform(
//                get("/TShirt/1234"));
//    }



    // broken
//    @Test
//    public void shouldReturnTShirtOnValidGetRequest() throws Exception {
//
//        doReturn(allTShirts).when(repo).findByTShirt("Blue");
//
//        mockMvc.perform(
//                        get("/TShirt/color/Blue")
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(allTShirtsJson)
//                );
//    }



    @Test
    public void shouldReturnAllTShirts() throws Exception {
        doReturn(allTShirts).when(repo).findAll();

        mockMvc.perform(
                        get("/TShirt"))
                .andExpect(status().isOk())
                .andExpect(content().json(allTShirtsJson)
                );
    }

@Test
public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
    mockMvc.perform(
                    put("/TShirt")
                            .content(tShirtJson)
                            .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNoContent());
}


    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/TShirt/2")).andExpect(status().isNoContent());
    }
}