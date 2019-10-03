package com.codecool.shooter.service;

import com.codecool.shooter.model.DuckCoordinatesResult;
import com.codecool.shooter.model.DuckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DuckManagerCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${duck-manager.url}")
    private String baseUrl;


    public DuckResult tryToKillDuck(DuckCoordinatesResult duckCoordinatesResult) {
        HttpEntity<DuckCoordinatesResult> request = new HttpEntity<>(duckCoordinatesResult);
        return restTemplate.postForObject(baseUrl + "/kill", request, DuckResult.class);
    }
}
