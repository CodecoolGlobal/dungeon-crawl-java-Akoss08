package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class Helmet extends Item{
    private static final int PLUS_DEFENSE = 2;
    private static final String TILE_NAME = "helmet";
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSwordAndShieldAndHelmet";

    public Helmet(Cell cell) {
        super(cell, TILE_NAME);
    }

    @Override
    public void addToPlayer(Player player) {
        player.getInventory().addItem(this);
        player.setDefense(player.getDefense() + PLUS_DEFENSE);
        player.setTileName(TILE_NAME_FOR_PLAYER);
    }
}
