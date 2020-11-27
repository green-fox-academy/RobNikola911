package com.spring.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.controllers.TestRestController;
import com.spring.security.models.Movie;
import com.spring.security.repositories.MovieRepository;
import com.spring.security.services.MovieService;
import com.spring.security.services.MovieServiceImpl;
import com.spring.security.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableWebMvc
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String jwt;
    private Movie movie;

    @Autowired
    UserServiceImpl userService;

    private final MovieService movieService = Mockito.mock(MovieService.class);

    @InjectMocks
    private TestRestController testRestController;

    @BeforeEach
    public void doBefore() throws Exception {

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"rob\",\"password\": \"asd\"}"))
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(post("/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"rob\",\"password\": \"asd\"}"))
                .andExpect(status().isOk()).andReturn();
        this.jwt = result.getResponse().getContentAsString();
    }

    @Test
    public void authenticatetestCase() throws Exception {
        Assert.assertNotNull(jwt);
    }

    @Test
    public void getMovieByIdTest() throws Exception {
        MockitoAnnotations.openMocks(this);

        movie = new Movie();
        movie.setId(3);
        movie.setTitle("Sabyasachi");

        when(movieService.getMovieById(3, "4d3e40f1f028b2d983ba6cd281aee20e")).thenReturn(movie);
        mockMvc = MockMvcBuilders.standaloneSetup(testRestController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/3?api_key=4d3e40f1f028b2d983ba6cd281aee20e")
                .header("Authorization", "Bearer " + jwt)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    //    @Test
//    public void getAllUserTest() throws Exception {
//        when(trackService.getAllTracks()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void updateTrackTest() throws Exception {
//        when(trackService.updateTrack(any())).thenReturn(true);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void deleteTrackTest() throws Exception {
//        when(trackService.deleteTrack(anyInt())).thenReturn(true);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track/2")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
//                .andExpect(MockMvcResultMatchers.status().isNoContent())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
