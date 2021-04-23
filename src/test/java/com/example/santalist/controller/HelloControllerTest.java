package com.example.santalist.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-22 <br>
 * Time: 13:13 <br>
 * Project: santaList <br>
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHelloTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalToIgnoringCase("Hello World!")));
    }

    @Test
    public void getHelloFalseTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(not("Hello World!!!!!!!!!!")));
    }

    @Test
    public void getHelloLengthTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(hasLength(12)));
    }

    @Test
    public void getHelloCustomTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(hasLength(12)))
                .andExpect(content().string(containsStringIgnoringCase("hello")))
                .andExpect(content().string(anything()))
                .andExpect(content().encoding("ISO-8859-1"));
    }

    @Test
    public void getHelloEspTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello/esp").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalToIgnoringCase("Hola Mundo!")));
    }

    @Test
    public void getHelloEspFalseTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello/esp").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(not("Hola Mundo!!!!!!!!")));
    }

}
