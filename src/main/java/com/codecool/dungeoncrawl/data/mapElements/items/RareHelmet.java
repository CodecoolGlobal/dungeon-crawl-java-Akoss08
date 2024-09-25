package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class RareHelmet extends Item {
    private static final int PRICE = 20;

    public RareHelmet() {
        super(PRICE);
    }

    @Override
    public void addToPlayer(Player player) {
        player.getInventory().addItem(this);
    }

    @Override
    public String getTileName() {
        return "rareHelmet";
    }
}


