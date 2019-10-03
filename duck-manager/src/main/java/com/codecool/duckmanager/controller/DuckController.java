package com.codecool.duckmanager.controller;

import com.codecool.duckmanager.model.Duck;
import com.codecool.duckmanager.model.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class DuckController {

//    @Autowired
//    RandomCoordinate randomCoordinate;

    private List<Duck> ducks = new ArrayList<>();

    @GetMapping("/ducks")
    public List<Duck> handleDucks() {
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

    @PostMapping("/kill")
    public Duck killDuck(@RequestBody Coordinate coordinate) {
        int hitBoxRange = 5;
        int shootX = coordinate.getX();
        int shootY = coordinate.getY();
        Duck duckToKill = null;

        for (Duck duck : ducks) {

            int duckX = duck.getCoordinate().getX();
            int duckY = duck.getCoordinate().getY();
//            duckX == shootX && duckY == shootY
            if (shootX >= duckX - hitBoxRange & shootX <= duckX + hitBoxRange
                    & shootY >= duckY - hitBoxRange & shootY <= duckY + hitBoxRange) {
                System.out.println("equal");
                duckToKill = duck;
            }
        }
        ducks.remove(duckToKill);
        return duckToKill;
    }


}
