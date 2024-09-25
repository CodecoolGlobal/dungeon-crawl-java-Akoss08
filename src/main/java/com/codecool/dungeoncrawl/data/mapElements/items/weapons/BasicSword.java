package com.codecool.dungeoncrawl.data.mapElements.items.weapons;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class BasicSword extends Weapon {
    private static final String TILE_NAME = "basicSword";
    public static final int PLUS_ATTACK = 2;
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSword";

    public BasicSword(Cell cell) {
        super(cell, TILE_NAME, PLUS_ATTACK);
    }

    @Override
    public void addToPlayer(Player player) {
        if (player.hasWeapon()) {
            player.dropWeapon();
        }
        player.getInventory().addItem(this);
        player.setCurrentWeapon(this);
        player.setAttackStrength(player.getAttackStrength() + PLUS_ATTACK);
        player.setTileName(TILE_NAME_FOR_PLAYER);
    }
}
