package com.codecool.duckmanager.service;

import com.codecool.duckmanager.model.Coordinate;
import com.codecool.duckmanager.model.Direction;
import com.codecool.duckmanager.model.Duck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DuckHandler {

    @Autowired
    CoordinateUpdater coordinateUpdater;

    private List<Duck> ducks = new ArrayList<>();
    private int xRange = 630;
    private int yRange = 470;


    public List<Duck> handleDucks() {
        if (ducks.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                ducks.add(new Duck());
            }
            for (Duck duck : ducks) {
                coordinateUpdater.randomizeStartPositionInRange(xRange, yRange, duck);
            }
            return ducks;
        } else {
            for (Duck duck : ducks) {
                if (duck.getCoordinate().getX() >= xRange - 7 && duck.getCoordinate().getX() <= xRange) {
                    duck.setDidTouchLeftSide(false);
                    duck.setDidTouchRightSide(true);

                } else if (duck.getCoordinate().getX() >= 0 && duck.getCoordinate().getX() <= 5) {
                    duck.setDidTouchRightSide(false);
                    duck.setDidTouchLeftSide(true);
                }
                this.move(duck);
            }
            return ducks;
        }
    }

    public Duck killDuck(Coordinate coordinate) {
        int hitBoxRange = 5;
        int shootX = coordinate.getX();
        int shootY = coordinate.getY();
        Duck duckToKill = null;

        for (Duck duck : ducks) {

            int duckX = duck.getCoordinate().getX();
            int duckY = duck.getCoordinate().getY();

            if (shootX >= duckX - hitBoxRange &&
                    shootX <= duckX + hitBoxRange &&
                    shootY >= duckY - hitBoxRange &&
                    shootY <= duckY + hitBoxRange) {
                duckToKill = duck;
            }
        }
        ducks.remove(duckToKill);
        return duckToKill;
    }


    private void move(Duck duck) {
        if (duck.getDidTouchLeftSide()) {
            goRight(duck);
        } else {
            goLeft(duck);
        }
    }

    private void goLeft(Duck duck) {
        int stepLeft = Direction.WEST.getX();
        int x = duck.getCoordinate().getX();
        int y = duck.getCoordinate().getY();
        x += stepLeft;
        duck.setCoordinate(new Coordinate(x, y));
    }

    private void goRight(Duck duck) {
        int stepRight = Direction.EAST.getX();
        int x = duck.getCoordinate().getX();
        int y = duck.getCoordinate().getY();
        x += stepRight;
        duck.setCoordinate(new Coordinate(x, y));
    }
}
