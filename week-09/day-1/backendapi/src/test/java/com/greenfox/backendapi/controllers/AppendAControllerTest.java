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
@WebMvcTest(AppendAController.class)
public class AppendAControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;

    @Test
    public void getPathvariable() throws Exception {
        mockMvc.perform(get("/appenda/kind"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.appended",is("kinda")));
    }
}
