package com.codecool.shooter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DuckResult {

    private Integer id = 0;
    private static Integer instanceCounter = 0;
    private DuckCoordinatesResult coordinate;

}
