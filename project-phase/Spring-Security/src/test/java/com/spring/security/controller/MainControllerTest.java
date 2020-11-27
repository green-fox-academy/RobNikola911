package com.spring.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.SecurityApplication;
import com.spring.security.models.Movie;
import com.spring.security.services.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SecurityApplication.class)
@WebMvcTest
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Movie movie, movie1;

    @MockBean
    private MovieServiceImpl movieService;

    @InjectMocks
    private MainControllerTest mainController;

    private List<Movie> list = null;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
        movie = new Movie();
        movie1 = new Movie();
        movie.setTitle("Sabyasachi");
        movie.setStatus("Released");
        list = new ArrayList();
        list.add(movie);
        movie1.setTitle("Sabya");
        movie1.setStatus("Upcoming");
        list.add(movie1);
    }

    @Test
    public void saveMovieTest() throws Exception {
        when(movieService.saveMovie(any())).thenReturn(movie);
        mockMvc.perform(get("movie/1")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
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
