package com.codecool.duckmanager.model;

import lombok.Data;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Data
@EnableScheduling
public class Duck {

    private Integer id = 0;
    private static Integer instanceCounter = 0;
    private Coordinate coordinate;

    public Duck() {
        instanceCounter++;
        this.id = instanceCounter;
        this.coordinate = new Coordinate(0, 0);
    }

    public void randomizeStartPositionInRange(int xRange, int yRange) {
        coordinate.randomizeStartPositionInRange(xRange, yRange);
    }

//    @Scheduled(fixedRate = 1000)
    public void changeCoordinatesRandomly() {
        Direction direction = Direction.getRandomDirection();

        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();

        x += direction.dX;
        y += direction.dY;

        this.setCoordinate(new Coordinate(x, y));
    }

}
