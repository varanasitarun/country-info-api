package org.example.service;


import org.example.exception.CountryNotFoundException;
import org.example.model.Country;
import org.example.model.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    @Value("${country.api.url}")
    private String apiUrl;
    private RestTemplate restTemplate;

    public CountryService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }
    public List<Country> getAllCountries() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl);
        CountryResponse countryResponse = restTemplate.getForObject(uriBuilder.toUriString(), CountryResponse.class);
        return countryResponse != null ? countryResponse.getData() : Collections.emptyList();

    }

    public Country getCountryByName(String name) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl);
        CountryResponse countryResponse = restTemplate.getForObject(uriBuilder.toUriString(), CountryResponse.class);
        if (countryResponse == null || countryResponse.getData().isEmpty()) {
            throw new CountryNotFoundException("No data available.");
        }

        return countryResponse.getData().stream()
                .filter(country -> country.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found: " + name));
    }





}
