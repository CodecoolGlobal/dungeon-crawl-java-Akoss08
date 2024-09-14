package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class Spider extends Monster {
    private static final int BASE_HEALTH = 10;
    private static final int BASE_POWER = 5;
    private static final String TILE_NAME = "spider";

    public Spider(Cell cell) {
        super(cell, BASE_HEALTH, BASE_POWER, TILE_NAME);
    }

}
