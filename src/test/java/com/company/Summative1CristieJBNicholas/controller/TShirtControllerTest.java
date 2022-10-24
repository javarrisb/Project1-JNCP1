package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.TShirt;
import com.company.Summative1CristieJBNicholas.repository.TShirtRepository;
//import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
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

//    @MockBean
//    ServiceLayer serviceLayer;
    private ObjectMapper mapper = new ObjectMapper();

    private TShirt gameStoreTShirt;

    private TShirt tShirts;

    private String outputTshirtJson;
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
        TShirt tShirts = new TShirt();
        tShirts.settShirtId(1);
        tShirts.setSize("X-Small");
        tShirts.setColor("Blue");
        tShirts.setDescription("GameStorePromo");
        tShirts.setPrice(10.99);
        tShirts.setQuantity(20);

//        outputTshirtJson = mapper.writeValueAsString(tShirts);
        allTShirts.add(tShirts);
        allTShirtsJson = mapper.writeValueAsString(allTShirts);
    }

    //from work done with RSVP-Service
    @Test
    public void shouldCreateNewTShirtOnPostRequest() throws Exception {
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

    @Test
    public void shouldReturnTShirtColorOnValidGetRequest() throws Exception {

        doReturn(allTShirts).when(repo).findByColor("Blue");

        mockMvc.perform(
                        get("/TShirt/color/Blue")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(allTShirtsJson)
                );
    }

    @Test
    public void shouldReturnTShirtSizeOnValidGetRequest() throws Exception {

        doReturn(allTShirts).when(repo).findBySize("Medium");

        mockMvc.perform(
                        get("/TShirt/size/Medium")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(allTShirtsJson)
                );
    }

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
          mockMvc.perform(delete("/TShirt/2")
                        .content(tShirtJson)
                        .contentType(MediaType.APPLICATION_JSON)
                  )
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/TShirt/1"))
                .andExpect(status().isNoContent());
    }

}