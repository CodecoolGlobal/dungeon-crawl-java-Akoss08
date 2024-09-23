package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class PowerPotion extends Item implements Interractable {
    private static final int PLUS_STRENGTH = 3;
    private static final String TILE_NAME = "powerPotion";
    private int duration = 3;

    public PowerPotion(Cell cell) {
        super(cell, TILE_NAME);
    }

    @Override
    public void addToPlayer(Player player) {
        player.getInventory().addItem(this);
    }

    @Override
    public void use(Player player) {
        player.setAttackStrength(player.getAttackStrength() + PLUS_STRENGTH);
    }

    public void resetPowerBoost(Player player) {
        player.setAttackStrength(player.getAttackStrength() - PLUS_STRENGTH);
    }

    public void decreaseDuration() {
        duration--;
    }

    public int getDuration() {
        return duration;
    }
}
