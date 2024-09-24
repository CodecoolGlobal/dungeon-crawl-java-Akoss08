package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class SnakeTooth extends Item {
    @Override
    public void addToPlayer(Player player) {
        player.getInventory().addItem(this);
    }

    @Override
    public String getTileName() {
        return "snakeTooth";
    }
}
