package com.tdd.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles( "tests" )
@RunWith( SpringRunner.class )
@AutoConfigureMockMvc
@SpringBootTest
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateSuccess() throws Exception {

        this.mockMvc.perform(
            post("/todo")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"todo\": \"Fix tests\"}")
        )
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", notNullValue()));
    }
}
