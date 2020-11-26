package com.spring.security;

import com.spring.security.configuration.JwtUtil;
import com.spring.security.controllers.TestRestController;
import com.spring.security.services.MyUserDetailsService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TestRestController.class)
public class AuthorizationTestInMemoryDB {

    private static final String URL = "/authenticate";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MyUserDetailsService service;

    @Test
    public void testLogin() throws Exception {
        Mockito.when(service.authenticate(Mockito.eq("user"), Mockito.eq("user"))).thenReturn("secret");

        String request = "{ \"username\": \"user\", \"password\": \"user\" }";
        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(request).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token", Matchers.is("secret")));
    }
}
