package com.codecool.duckmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class Duck {

    private Integer id = 0;
    private static Integer instanceCounter = 0;
    private Coordinate coordinate;

    @JsonIgnore
    private Boolean didTouchLeftSide = true;
    @JsonIgnore
    private Boolean didTouchRightSide = false;

    public Duck() {
        instanceCounter++;
        this.id = instanceCounter;
        this.coordinate = new Coordinate(0, 0);
    }

    public void randomizeStartPositionInRange(int xRange, int yRange) {
        coordinate.randomizeStartPositionInRange(xRange, yRange);
    }

//    public void changeCoordinatesRandomly() {
//        Direction direction = Direction.getRandomDirection();
//
//        int x = this.getCoordinate().getX();
//        int y = this.getCoordinate().getY();
//
//        x += direction.dX;
//        y += direction.dY;
//
//        this.setCoordinate(new Coordinate(x, y));
//    }




    public void move() {
        if (this.didTouchLeftSide) {
            goRight();
        } else {
            goLeft();
        }
    }

    private void goLeft() {
        int stepLeft = Direction.WEST.getX();
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();
        x += stepLeft;
        this.setCoordinate(new Coordinate(x, y));
    }

    private void goRight() {
        int stepRight = Direction.EAST.getX();
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();
        x += stepRight;
        this.setCoordinate(new Coordinate(x, y));
    }

}
