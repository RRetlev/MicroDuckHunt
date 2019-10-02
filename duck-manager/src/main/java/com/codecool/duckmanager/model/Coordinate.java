package com.codecool.duckmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@Data
public class Coordinate {

    private int x;
    private int y;

    @JsonIgnore
    private Random random = new Random();

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void randomizeStartPositionInRange(int xRange, int yRange) {
        this.setX(random.nextInt(xRange));
        this.setY(random.nextInt(yRange));
    }
}
