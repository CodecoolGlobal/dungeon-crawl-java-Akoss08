package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class PowerPotion extends Item {
    private static final int PLUS_STRENGTH = 3;
    private static final String TILE_NAME = "powerPotion";

    public PowerPotion(Cell cell) {
        super(cell, TILE_NAME);
    }

    @Override
    public void setAbility(Player player) {
        player.getInventory().addItem(this);
    }

    public int getStrength() {
        return PLUS_STRENGTH;
    }
}
