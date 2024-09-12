package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;

public class PowerPotion extends Item{
    public static final int PLUS_STRENGTH = 3;

    public PowerPotion(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "powerPotion";
    }
}
