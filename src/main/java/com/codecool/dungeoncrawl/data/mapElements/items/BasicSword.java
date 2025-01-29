package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;

public class BasicSword extends Weapon {
    private static final String TILE_NAME = "basicSword";
    public static final int PLUS_ATTACK = 2;
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSword";

    public BasicSword(Cell cell) {
        super(cell, TILE_NAME, PLUS_ATTACK, TILE_NAME_FOR_PLAYER);
    }
}
