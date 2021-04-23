package com.example.santalist.controllers;

import com.example.santalist.models.Capital;
import com.example.santalist.models.Child;
import com.example.santalist.models.Country;
import com.example.santalist.models.Present;
import com.example.santalist.repositories.ChildRepo;
import com.example.santalist.repositories.CountryRepo;
import com.example.santalist.repositories.PresentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/child")
public class ChildController {

    @Autowired
    CountryRepo countryRepo;

    @Autowired
    ChildRepo childRepo;

    @Autowired
    PresentRepo presentRepo;

    private static final Logger log =
            LoggerFactory.getLogger(CapitalController.class);

    @GetMapping(path = "/addWithCountry")
    public String addChildAndCapital(@RequestParam String childP, @RequestParam String countryP){

        Country existingCountry = countryRepo.findByName(countryP);
        Child child = new Child(childP, existingCountry);
        childRepo.save(child);

        return "Saved a child with name: " +childP;
    }

//    @GetMapping(path = "/addWithPresent")
//    public String addChildAndPresent(@RequestParam String childP, @RequestParam String countryP, @RequestParam String wishP){
//
//        Country existingCountry = countryRepo.findByName(countryP);
//        Present existingPresent = presentRepo.findByName(wishP);
//        if(existingPresent == null){
//            Present p = new Present(wishP);
//            presentRepo.save(p);
//            existingPresent = presentRepo.findByName(p.getName());
//        }
//        List<Present> presentList = Arrays.asList(existingPresent);
//
//        Child c = childRepo.findByName(childP);
//        if(c != null){
//            c.getWishes().addAll(presentList);
//            childRepo.save(c);
//            return "Added a wish for child: " + childP + " that wishes for: " + wishP;
//        }
//        else{
//            Child child = new Child(childP, existingCountry, presentList);
//            childRepo.save(child);
//            return "Updated child: " + childP + " with wish for: " + wishP;
//        }
//    }

    @GetMapping(path = "/add")
    public String addChild(@RequestParam String name){
        childRepo.save(new Child(name));
        log.info("Added child with name: "+ name);
        return "Saved a child with name: " +name;
    }

    @GetMapping(path = "/get/all")
    public List<Child> getAllChildren(){
        return childRepo.findAll();
    }

    @GetMapping(path = "/get/id")
    public Optional<Child> getChildById(@RequestParam Long id){
        return childRepo.findById(id);
    }

}
