package com.codecool.duckmanager.controller;

import com.codecool.duckmanager.model.Duck;
import com.codecool.duckmanager.model.Coordinate;
import com.codecool.duckmanager.service.DuckHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DuckController {

    @Autowired
    DuckHandler duckHandler;

    @CrossOrigin
    @GetMapping("/ducks")
    public List<Duck> handleDucks() {
        return duckHandler.handleDucks();
    }

    @CrossOrigin
    @PostMapping("/kill")
    public Duck killDuck(@RequestBody Coordinate coordinate) {
        return duckHandler.killDuck(coordinate);
    }


}
