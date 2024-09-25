package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class BasicSpear extends Item {
    private static final int PRICE = 60;

    public BasicSpear() {
        super(PRICE);
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
