package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class Spider extends Monster {
    private static final int BASE_HEALTH = 20;
    private static final int BASE_POWER = 1;
    private static final int XP_VALUE = 2;
    private static final String TILE_NAME = "spider";

    public Spider(Cell cell) {
        super(cell, BASE_HEALTH, BASE_POWER, TILE_NAME, XP_VALUE);
    }

}
