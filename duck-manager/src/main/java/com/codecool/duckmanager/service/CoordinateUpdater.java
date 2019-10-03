package com.codecool.duckmanager.service;

import com.codecool.duckmanager.model.Coordinate;
import com.codecool.duckmanager.model.Duck;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CoordinateUpdater {

    private Random random = new Random();

    public void randomizeStartPositionInRange(int xRange, int yRange, Duck duck) {
        int x = random.nextInt(xRange);
        int y = random.nextInt(yRange);

        duck.setCoordinate(new Coordinate(x, y));
    }
}
