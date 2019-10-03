package com.codecool.duckmanager.controller;

import com.codecool.duckmanager.model.Duck;
import com.codecool.duckmanager.model.Coordinate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class DuckController {

//    @Autowired
//    Coordinate coordinate;

    private List<Duck> ducks = new ArrayList<>();
    private int xRange = 640;
    private int yRange = 480;

    @GetMapping("/ducks")
    public List<Duck> handleDucks() {
        if (ducks.isEmpty()) {
            for (int i = 0; i < 1; i++) {
                ducks.add(new Duck());
            }
            for (Duck duck : ducks) {
                duck.randomizeStartPositionInRange(xRange, yRange);
            }
            return ducks;
        } else {
            for (Duck duck : ducks) {
                if (duck.getCoordinate().getX() == xRange) {
                    duck.setDidTouchLeftSide(false);
                    duck.setDidTouchRightSide(true);

                } else if (duck.getCoordinate().getX() == 0) {
                    duck.setDidTouchRightSide(false);
                    duck.setDidTouchLeftSide(true);
                }
                duck.move();
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
