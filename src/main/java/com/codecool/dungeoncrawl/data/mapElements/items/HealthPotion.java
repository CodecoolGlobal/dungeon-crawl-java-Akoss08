package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class HealthPotion extends Item implements Interractable{
    private static final String TILE_NAME = "healthPotion";

    public HealthPotion(Cell cell) {
        super(cell, TILE_NAME);
    }

    @Override
    public void addToPlayer(Player player) {
        player.getInventory().addItem(this);
    }

    @Override
    public void use(Player player) {
        player.setHealth(player.getBaseHealth());
    }
}
