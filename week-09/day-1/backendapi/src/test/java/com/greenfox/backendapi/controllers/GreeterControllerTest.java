package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.services.LogService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GreeterController.class)
public class GreeterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;

    @Test
    public void getParam() throws Exception {
        mockMvc.perform(get("/greeter?name=Peti&title=Student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.welcome_message",is("Oh, hi there Peti, my dear Student!")));
    }

    @Test
    public void getParamWithoutTitle() throws Exception {
        mockMvc.perform(get("/greeter?name=Peti"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error",is("Please provide a title!")));
    }

    @Test
    public void getParamWithoutName() throws Exception {
        mockMvc.perform(get("/greeter?title=Student"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error",is("Please provide a name!")));
    }

    @Test
    public void getParamWithoutNameAndTitle() throws Exception {
        mockMvc.perform(get("/greeter"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error",is("Please provide a name and a title!")));
    }
}
