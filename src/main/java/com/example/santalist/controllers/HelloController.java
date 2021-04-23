package com.example.santalist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-22 <br>
 * Time: 13:10 <br>
 * Project: santaList <br>
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(path = "/")
    public String getMessageEng(){
        return "Hello World!";
    }

    @GetMapping(path = "/esp")
    public String getMessageEsp(){
        return "Hola Mundo!";
    }
}
