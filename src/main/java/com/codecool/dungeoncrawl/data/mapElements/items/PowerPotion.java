package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;

public class PowerPotion extends Item{
    public PowerPotion(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "powerPotion";
    }
}
