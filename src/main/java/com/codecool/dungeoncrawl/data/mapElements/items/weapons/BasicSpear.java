package com.codecool.dungeoncrawl.data.mapElements.items.weapons;

import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class BasicSpear extends Weapon {
    private static final int PRICE = 60;
    private static final int PLUS_ATTACK = 4;
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSpear";

    public BasicSpear() {
        super(PRICE, PLUS_ATTACK);
    }

    @Override
    public void addToPlayer(Player player) {
        player.getInventory().addItem(this);
    }

    @Override
    public String getTileName() {
        return "spear";
    }
}
