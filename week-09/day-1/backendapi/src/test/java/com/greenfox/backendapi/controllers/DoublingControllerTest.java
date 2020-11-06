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
@WebMvcTest(DoublingController.class)
public class DoublingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;

    @Test
    public void getParamDoublingTest() throws Exception {
        mockMvc.perform(get("/doubling?input=20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(40)));
    }

    @Test
    public void getErrorDoublingTest() throws Exception {
        mockMvc.perform(get("/doubling"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error",is("Please provide an input!")));
    }
}
