package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public abstract class Armor extends Item {
    private final int defense;
    private final String tileNameForPlayer;

    public Armor(int price, int defense, String tileNameForPlayer) {
        super(price);
        this.defense = defense;
        this.tileNameForPlayer = tileNameForPlayer;
    }

    public Armor(Cell cell, String tileName, int defense, String tileNameForPlayer) {
        super(cell, tileName);
        this.defense = defense;
        this.tileNameForPlayer = tileNameForPlayer;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public void addToPlayer(Player player) {
        if (player.hasArmor()) {
            player.dropArmor();
        }
        player.getInventory().addItem(this);
        player.setCurrentArmor(this);
        player.setDefense(player.getDefense() + defense);
        player.setTileName(tileNameForPlayer);
    }
}
