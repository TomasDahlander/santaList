package com.example.santalist.controller;

import com.example.santalist.models.Capital;
import com.example.santalist.repositories.CapitalRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-22 <br>
 * Time: 14:20 <br>
 * Project: santaList <br>
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CapitalControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CapitalRepo mockRepo;

    @BeforeEach
    public void init(){
        Capital c1 = new Capital(1L,"Oslo");
        Capital c2 = new Capital(2L,"London");
        Capital c3 = new Capital(3L,"Tokyo");
        when(mockRepo.findById(1L)).thenReturn(Optional.of(c1));
        when(mockRepo.findById(2L)).thenReturn(Optional.of(c2));
        when(mockRepo.findById(3L)).thenReturn(Optional.of(c3));
        when(mockRepo.findAll()).thenReturn(Arrays.asList(c1,c2,c3));
    }

    @Test
    public void addCapitalTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/capital/add?name=Bangkok").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalToIgnoringCase("Saved a capital with name: Bangkok")));
    }

    @Test
    public void getCapitalById1Test() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/capital/get/id?id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Oslo\"}"));
    }

    @Test
    public void getAllCapitalTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/capital/get/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Oslo\"},{\"id\":2,\"name\":\"London\"},{\"id\":3,\"name\":\"Tokyo\"}]"));
    }

    @Test
    public void getAllCapitalCountTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/capital/get/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

//    @Test
//    public void getAllCapitalTest() throws Exception{
//        mvc.perform(MockMvcRequestBuilders.get("/capital/get/id?id=2").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().json("""
//                        [
//                            {"id": 1, "name": "Oslo"},
//                            {"id": 2, "name": "London"},
//                            {"id": 3, "name": "Tokyo"}
//                        ]
//                    """));
//    }

    /*
    """
        [{"id": 1, "capitalName": "Buenos Aires"},
        {"id": 2, "capitalName": "Santiago"},
        {"id": 3, "capitalName": "Lima"}]
    """

     */

}
/*
@GetMapping(path = "/add")
    public String addCapital(@RequestParam String name){
        capitalRepo.save(new Capital(name));
        log.info("INFO - Capital added with name: " + name);
        return "Saved a capital with name: " + name;
    }
 */