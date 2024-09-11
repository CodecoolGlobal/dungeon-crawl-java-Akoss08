package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class Sword extends Item {

    public Sword(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "sword";
    }

    @Override
    public void setAbility(Player player) {
        player.setAttackStrength(7);
    }
}
