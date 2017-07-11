package com.tdd.demo;

import com.tdd.demo.controller.TODOController;
import com.tdd.demo.model.TODO;
import com.tdd.demo.model.TODOService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TODOController.class)
public class TODOControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TODOService todoService;

    @Test
    public void testGetTodoList() throws Exception {

        when(this.todoService.findAll()).thenReturn(
            Stream.of(new TODO(1L, "Implement Service")).collect(Collectors.toList())
        );

        this.mockMvc.perform(
            get("/todos")
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isNotEmpty())
            .andExpect(jsonPath("$[0].id", notNullValue()))
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("$[0].name", notNullValue()));

        verify(this.todoService, times(1)).findAll();
    }
}
