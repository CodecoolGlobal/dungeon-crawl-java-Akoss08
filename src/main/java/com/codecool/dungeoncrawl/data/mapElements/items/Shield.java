package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class Shield extends Item {

    public Shield(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "shield";
    }

    @Override
    public void setAbility(Player player) {
        player.setDefense(1);
    }
}
