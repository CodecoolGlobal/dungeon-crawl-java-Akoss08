package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class BasicShield extends Item {
    private static final String TILE_NAME = "basicShield";
    private static final int PLUS_DEFENSE = 1;
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSwordAndShield";

    public BasicShield(Cell cell) {
        super(cell, TILE_NAME);
    }

    @Override
    public void addToPlayer(Player player) {
        player.getInventory().addItem(this);
        player.setDefense(player.getDefense() + PLUS_DEFENSE);
        player.setTileName(TILE_NAME_FOR_PLAYER);
    }
}
