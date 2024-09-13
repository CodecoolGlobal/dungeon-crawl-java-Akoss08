package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class Helmet extends Item{
    private static final int PLUS_DEFENSE = 2;

    public Helmet(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "helmet";
    }

    @Override
    public void setAbility(Player player) {
        player.setDefense(player.getDefense() + PLUS_DEFENSE);
    }
}
