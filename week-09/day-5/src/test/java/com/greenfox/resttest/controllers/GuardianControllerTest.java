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
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getNotExistingParam() throws Exception {
        mockMvc.perform(get("/groot"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error",is("I am Groot!")));
    }

    @Test
    public void getExistingParam() throws Exception {
        mockMvc.perform(get("/groot?message=somemessage"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.recieved",is("somemessage")))
                .andExpect(jsonPath("$.translated",is("I am Groot!")));
    }

//    @Test
//    void controlTest(){
//        String unittest = "Test message";
//        GuardianController controller = new GuardianController();
//        Assert.assertEquals("Test message", controller.getGroot(unittest)
//                .getBody()
//                .getRecieved());
//    }
}
