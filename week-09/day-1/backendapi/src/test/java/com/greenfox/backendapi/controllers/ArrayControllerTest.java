package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.services.LogService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ArrayController.class)
public class ArrayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;

    @Test
    public void arraysPostSum() throws Exception {
        mockMvc.perform(post("/arrays")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"what\": \"sum\", \"numbers\": [1,2,5,10]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(18)));
    }

    @Test
    public void arraysPostMultiply() throws Exception {
        mockMvc.perform(post("/arrays")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"what\": \"multiply\", \"numbers\": [1,2,5,10]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(100)));
    }

    @Test
    public void arraysPostDouble() throws Exception {
        mockMvc.perform(post("/arrays")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"what\": \"double\", \"numbers\": [1,2,5,10]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(Arrays.asList(2,4,10,20))));
    }
    @Test
    public void arraysPostDoubleError() throws Exception {
        mockMvc.perform(post("/arrays")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"numbers\": [1,2,5,10]}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error",is("Please provide a number!")));
    }

}
