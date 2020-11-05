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

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(DoUntilController.class)
public class DoUntilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;

    @Test
    public void getPathvariablePostSum() throws Exception {
        mockMvc.perform(post("/dountil/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"until\": 5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(15)));
    }

    @Test
    public void getPathvariablePostFactor() throws Exception {
        mockMvc.perform(post("/dountil/factor")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"until\": 5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(120)));
    }

    @Test
    public void getError() throws Exception {
        mockMvc.perform(post("/dountil/factor")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error",is("Please provide a number!")));
    }
}
