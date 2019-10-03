package com.codecool.shooter.controller;

import com.codecool.shooter.model.DuckCoordinatesResult;
import com.codecool.shooter.model.DuckResult;
import com.codecool.shooter.service.DuckManagerCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ShooterController {

    @Autowired
    DuckManagerCaller duckCaller;

    @PostMapping("/shoot")
    public DuckResult shootDuck(@RequestBody DuckCoordinatesResult duckCoordinates) {
        return duckCaller.tryToKillDuck(duckCoordinates);
    }

}
