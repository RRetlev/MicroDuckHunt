package com.codecool.duckmanager.controller;

import com.codecool.duckmanager.model.Duck;
import com.codecool.duckmanager.model.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class DuckController {

//    @Autowired
//    RandomCoordinate randomCoordinate;

    //    private Coordinate coordinate = new Coordinate(0,0);
    private List<Duck> ducks = new ArrayList<>();

    @GetMapping("/ducks")
    public List<Duck> createDucks() {
        if (ducks.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                ducks.add(new Duck());
            }
            for (Duck duck : ducks) {
                duck.randomizeStartPositionInRange(640, 480);
            }
            return ducks;
        } else {
            for (Duck duck : ducks) {
                duck.changeCoordinatesRandomly();
            }
            return ducks;
        }
    }
}
