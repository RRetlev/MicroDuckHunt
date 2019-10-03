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
}
