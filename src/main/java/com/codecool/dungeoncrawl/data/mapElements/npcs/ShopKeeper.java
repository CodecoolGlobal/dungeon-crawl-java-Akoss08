package com.codecool.dungeoncrawl.data.mapElements.npcs;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class ShopKeeper extends Npc {
    private static final String BASE_DIALOG = "Ahoy";
    private static final String TILE_NAME = "shopKeeper";

    public ShopKeeper(Cell cell) {
        super(BASE_DIALOG, cell, TILE_NAME);
    }

    @Override
    public void interact(Player player) {

    }
}
