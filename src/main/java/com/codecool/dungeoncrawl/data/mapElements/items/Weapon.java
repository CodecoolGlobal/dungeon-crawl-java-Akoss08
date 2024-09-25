package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public abstract class Weapon extends Item {
    private final int damage;
    private final String tileNameForPlayer;

    public Weapon(int price, int damage, String tileNameForPlayer) {
        super(price);
        this.damage = damage;
        this.tileNameForPlayer = tileNameForPlayer;
    }

    public Weapon(Cell cell, String tileName, int damage, String tileNameForPlayer) {
        super(cell, tileName);
        this.damage = damage;
        this.tileNameForPlayer = tileNameForPlayer;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void addToPlayer(Player player) {
        if (player.hasWeapon()) {
            player.dropWeapon();
        }
        player.getInventory().addItem(this);
        player.setCurrentWeapon(this);
        player.setAttackStrength(player.getAttackStrength() + damage);
        player.setTileName(tileNameForPlayer);
    }
}
