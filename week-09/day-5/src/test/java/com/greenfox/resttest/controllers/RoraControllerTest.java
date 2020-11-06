package com.greenfox.resttest.controllers;

import com.greenfox.resttest.services.RoraService;
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
@WebMvcTest(GuardianController.class)
public class RoraControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoraService roraService;

    @Test
    public void getRocket() throws Exception {
        mockMvc.perform(get("/rocket"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.caliber25",is(0)))
                .andExpect(jsonPath("$.caliber30",is(0)))
                .andExpect(jsonPath("$.caliber50",is(0)))
                .andExpect(jsonPath("$.ready",is(false)))
                .andExpect(jsonPath("$.shipstatus",is("empty")));
    }

    @Test
    public void getExistingParam() throws Exception {
        mockMvc.perform(get("/rocket/fill?caliber=.30&amount=500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.received",is(".30")))
                .andExpect(jsonPath("$.amount",is(500)));

    }
}
