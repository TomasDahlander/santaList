package com.example.santalist.controllers;

import com.example.santalist.models.Capital;
import com.example.santalist.models.Present;
import com.example.santalist.repositories.CapitalRepo;
import com.example.santalist.repositories.PresentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/present")
public class PresentController {

    @Autowired
    PresentRepo presentRepo;

    private static final Logger log =
            LoggerFactory.getLogger(CapitalController.class);

    @GetMapping(path = "/add")
    public String addCapital(@RequestParam String name){
        presentRepo.save(new Present(name));
        return "Saved a present with name: " +name;
    }

    @GetMapping(path = "/get/all")
    public List<Present> getAllCapitals(){
        return presentRepo.findAll();
    }

    @GetMapping(path = "/get/id")
    public Optional<Present> getCapitalById(@RequestParam Long id){
        return presentRepo.findById(id);
    }

}
