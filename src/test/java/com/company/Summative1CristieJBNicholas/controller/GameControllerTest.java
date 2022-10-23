package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.Games;
import com.company.Summative1CristieJBNicholas.repository.GameRepository;
import com.company.Summative1CristieJBNicholas.services.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
@WebMvcTest(GameController.class)

public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameRepository repo;
    @MockBean
    ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    private Games gameStoreGames;
    private Games games;
    private String inputGameJson;
    private String outGameJson;

    private List<Games> allGames = new ArrayList<>();

    private String allGamesJson;

    @Before
    public void setUp() throws Exception {
        // input

        gameStoreGames = new Games();
        gameStoreGames.setTitle("Minecraft");
        gameStoreGames.setEsrbRating("Ten+");
        gameStoreGames.setDescription("A 3D sandbox game that allows players a large amount of freedom in choosing how to play the game.");
        gameStoreGames.setPrice(19.99);
        gameStoreGames.setStudio("Mojang");
        gameStoreGames.setQuantity(100);

        inputGameJson = mapper.writeValueAsString(gameStoreGames);

        // output
//        Games games = new Games();
//        games.setId(1);

         games = new Games();
        games.setGame_Id(1);

        games.setTitle("Minecraft");
        games.setEsrbRating("Ten+");
        games.setDescription("A 3D sandbox game that allows players a large amount of freedom in choosing how to play the game.");
        games.setPrice(19.99);
        games.setStudio("Mojang");
        games.setQuantity(100);

        outGameJson = mapper.writeValueAsString(games);
        allGames.add(games);
        allGamesJson = mapper.writeValueAsString(allGames);
    }

    @Test
    public void shouldCreateNewGameOnPostRequest() throws Exception {

//       // orig
//        Games inputGames = new Games();
//        inputGames.setId(1);
//        inputGames.setTitle("Minecraft");
//        inputGames.setEsrbRating("Ten+");
//        inputGames.setDescription("A 3D sandbox game that allows players a large amount of freedom in choosing how to play the game.");
//        inputGames.setPrice(19.99);
//        inputGames.setStudio("Mojang");
//        inputGames.setQuantity(100);

//        Games inputGames = new Games();
////        inputGames.setGame_Id(1);
//        inputGames.setTitle("Minecraft");
//        inputGames.setEsrbRating("Ten+");
//        inputGames.setDescription("A 3D sandbox game that allows players a large amount of freedom in choosing how to play the game.");
//        inputGames.setPrice(19.99);
//        inputGames.setStudio("Mojang");
//        inputGames.setQuantity(100);


        String inputJson = mapper.writeValueAsString(gameStoreGames);
        doReturn(games).when(serviceLayer).addGame(gameStoreGames);

        mockMvc.perform(
                        post("/games")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(outGameJson));

    }

    @Test
    public void shouldReturnGamesById() throws Exception {
        doReturn(Optional.of(games)).when(serviceLayer).getSingleGameById(1);
        ResultActions result = mockMvc.perform(
                        get("/games/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(outGameJson))
                );
    }

    @Test
    public void shouldReturnTitleOnValidGetRequest() throws Exception {
        doReturn(Optional.of(games)).when(serviceLayer).findByTitle("Minecraft");
        mockMvc.perform(
                        get("/games/title/Minecraft")
//                                .contentType(MediaType.APPLICATION_JSON)****** used only for puts and posts
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outGameJson)
                );
    }

    @Test
    public void shouldReturnStudioOnValidGetRequest() throws Exception {

        doReturn(allGames).when(serviceLayer).getGamesByStudio("Mojang");

        mockMvc.perform(
                        get("/games/studio/Mojang")
//                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(allGamesJson)
                );
    }

//    @Test
////    public void shouldReturnEsrbRatingOnValidGetRequest() throws Exception {
//////should I have this as local variable and initialized as null??
////        String esrbRating = null;
////
////        doReturn(allGames).when(serviceLayer).findByEsrbRating("NR", esrbRating);
////
////        mockMvc.perform(
////                        get("/games/esrbRating/NR")
////                                .contentType(MediaType.APPLICATION_JSON)
////                )
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(content().json(allGamesJson)
////                );
////    }


    @Test
    public void shouldReturnAllGames() throws Exception {
        doReturn(allGames).when(serviceLayer).getAllGames();

        mockMvc.perform(
                        get("/games/game"))
                .andExpect(status().isOk())
                .andExpect(content().json(allGamesJson)
                );
    }

    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        doReturn(Optional.of(games)).when(serviceLayer).getSingleGameById(1);/** needed this*/
        mockMvc.perform(
                        put("/games/{id}", 1)
                                .content(outGameJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        doReturn(Optional.of(games)).when(serviceLayer).getSingleGameById(2);   /** needed this*/
            mockMvc.perform(delete("/games/2")).andExpect(status().isNoContent());
    }
}