package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;

public class BasicShield extends Armor {
    private static final String TILE_NAME = "basicShield";
    private static final int PLUS_DEFENSE = 1;
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSwordAndShield";

    public BasicShield(Cell cell) {
        super(cell, TILE_NAME, PLUS_DEFENSE, TILE_NAME_FOR_PLAYER);
    }
}
