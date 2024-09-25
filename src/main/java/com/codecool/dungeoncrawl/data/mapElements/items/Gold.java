package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class Gold extends Item {
    private static final String TILE_NAME = "gold";
    private final int goldValue;

    public Gold(Cell cell, int goldValue) {
        super(cell, TILE_NAME);
        this.goldValue = goldValue;
    }

    @Override
    public void addToPlayer(Player player) {
        player.collectGold(goldValue);
    }

}
