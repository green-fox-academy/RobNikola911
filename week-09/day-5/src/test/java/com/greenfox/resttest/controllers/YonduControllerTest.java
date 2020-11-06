package com.greenfox.resttest.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(YonduController.class)
public class YonduControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getNotExistingParam() throws Exception {
        mockMvc.perform(get("/yondu"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error",is("Distance or time is null")));
    }

    @Test
    public void getExistingParam() throws Exception {
        mockMvc.perform(get("/yondu?distance=110&time=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.distance",is(110.0)))
                .andExpect(jsonPath("$.time",is(10.0)))
                .andExpect(jsonPath("$.speed",is(11.0)));
    }

    @Test
    public void getExistingParamTimeZero() throws Exception {
        mockMvc.perform(get("/yondu?distance=110&time=0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.distance",is(110.0)))
                .andExpect(jsonPath("$.time",is(0.0)))
                .andExpect(jsonPath("$.speed",is("Infinity")));
    }
}
