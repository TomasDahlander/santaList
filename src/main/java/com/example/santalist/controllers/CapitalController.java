package com.example.santalist.controllers;

import com.example.santalist.models.Capital;
import com.example.santalist.repositories.CapitalRepo;
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
@RequestMapping("/capital")
public class CapitalController {

    @Autowired
    CapitalRepo capitalRepo;

    private static final Logger log =
        LoggerFactory.getLogger(CapitalController.class);

    @GetMapping(path = "/add")
    public String addCapital(@RequestParam String name){
        capitalRepo.save(new Capital(name));
        log.info("INFO - Capital added with name: " + name);
        return "Saved a capital with name: " + name;
    }

    @GetMapping(path = "/get/all")
    public List<Capital> getAllCapitals(){
        log.info("Someone wanted to see all capitals.");
        return capitalRepo.findAll();
    }

    @GetMapping(path = "/get/id")
    public Optional<Capital> getCapitalById(@RequestParam Long id){
        return capitalRepo.findById(id);
    }

}
