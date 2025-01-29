package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;

public class BasicHelmet extends Armor{
    private static final int PLUS_DEFENSE = 2;
    private static final String TILE_NAME = "basicHelmet";
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSwordAndShieldAndHelmet";

    public BasicHelmet(Cell cell) {
        super(cell, TILE_NAME, PLUS_DEFENSE, TILE_NAME_FOR_PLAYER);
    }
}
