package org.example.controller;

import org.example.model.Country;
import org.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries()
    {
        return countryService.getAllCountries();
    }
    @GetMapping("/countries/name")
    public Country getCountryByName(@RequestParam String name) {
        return countryService.getCountryByName(name);
    }

}
