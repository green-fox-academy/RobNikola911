package com.greenfox.backendapi;

import com.greenfox.backendapi.controllers.GreeterController;
import com.greenfox.backendapi.services.LogService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest()
class BackendapiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;


    @Test
    void contextLoads() {

        GreeterController greeter = new GreeterController(logService);
    }

}
