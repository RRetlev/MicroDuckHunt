package com.codecool.duckmanager.model;

import java.util.Random;

public enum Direction {
    NORTH(0, -2),
    EAST(2, 0),
    SOUTH(0, 2),
    WEST(-2, 0);

    public final int dX;
    public final int dY;
    private static final int SIZE = Direction.values().length;

    private static final Random random = new Random();


    Direction(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }

    public int getX() {
        return dX;
    }

    public int getY() {
        return dY;
    }

    public static Direction getRandomDirection() {
        return Direction.values()[random.nextInt(SIZE)];
    }
}
