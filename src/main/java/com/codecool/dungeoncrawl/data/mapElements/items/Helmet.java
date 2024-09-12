package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class Helmet extends Item{

    public Helmet(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "helmet";
    }

    @Override
    public void setAbility(Player player) {
        player.setDefense(player.getDefense() + 2);
    }
}
