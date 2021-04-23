package com.example.santalist.controllers;

import com.example.santalist.models.Capital;
import com.example.santalist.models.Country;
import com.example.santalist.repositories.CapitalRepo;
import com.example.santalist.repositories.CountryRepo;
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
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryRepo countryRepo;

    @Autowired
    CapitalRepo capitalRepo;

    private static final Logger log =
            LoggerFactory.getLogger(CapitalController.class);

    @GetMapping(path = "/addWithCapital")
    public String addCountryAndCapital(@RequestParam String countryP, @RequestParam String capitalP){

        Capital capital = capitalRepo.findByName(capitalP);
        Country country = countryRepo.findByName(countryP);

        if(capital == null && country == null) {
            Capital ca = new Capital(capitalP);
            Country co = new Country(countryP,ca);
            countryRepo.save(co);
        }
        else if(capital == null) {
            Capital ca = new Capital(capitalP);
            country.setCapital(ca);
            countryRepo.save(country);
        }
        else{
            Country co = new Country(countryP,capital);
            countryRepo.save(co);
        }
        log.info("A country was added with name: " + countryP);
        return "Saved a country with name: " +countryP;
    }

    @GetMapping(path = "/add")
    public String addCountry(@RequestParam String name){
        countryRepo.save(new Country(name));
        return "Saved a country with name: " +name;
    }

    @GetMapping(path = "/get/all")
    public List<Country> getAllCountries(){
        return countryRepo.findAll();
    }

    @GetMapping(path = "/get/id")
    public Optional<Country> getCountryById(@RequestParam Long id){
        return countryRepo.findById(id);
    }
}
