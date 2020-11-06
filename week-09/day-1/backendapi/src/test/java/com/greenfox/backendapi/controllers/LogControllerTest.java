package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.DTOs.LogDTO;
import com.greenfox.backendapi.models.Log;
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
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LogController.class)
public class LogControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;


    private LogDTO getLogsDTO(){
        LogDTO testLogs = new LogDTO();
        testLogs.setEntries(Arrays.asList(new Log("\"/arrays\"", "\"double,[1, 2, 5, 10]\""),
                new Log("\"/arraytest\"", "\"double,[1, 2, 5, 11]\"")));
        testLogs.setEntry_count(2);
        return testLogs;
    };

    @Test
    public void logServiceTest() throws Exception {

        when(logService.logEntries()).thenReturn(getLogsDTO());

        mockMvc.perform(get("/log"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entries",hasSize(2)))
                .andExpect(jsonPath("$.entries[1].endpoint",is("\"/arraytest\"")));
    }

    @Test
    public void logServiceEntrycount() throws Exception {
        when(logService.logEntries()).thenReturn(getLogsDTO());

        mockMvc.perform(get("/log"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entry_count",is(2)));
    }

}
