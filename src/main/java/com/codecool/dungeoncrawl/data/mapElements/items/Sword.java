package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class Sword extends Item {
    private static final String TILE_NAME = "sword";
    private static final int PLUS_ATTACK = 2;
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSword";

    public Sword(Cell cell) {
        super(cell, TILE_NAME);
    }

    @Override
    public void addToPlayer(Player player) {
        player.getInventory().addItem(this);
        player.setAttackStrength(player.getAttackStrength() + PLUS_ATTACK);
        player.setTileName(TILE_NAME_FOR_PLAYER);
    }
}
