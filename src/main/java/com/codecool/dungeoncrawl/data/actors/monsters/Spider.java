package com.codecool.dungeoncrawl.data.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class Spider extends Monster {
    public Spider(Cell cell) {
        super(cell);
        setHealth(20);
        setAttackStrength(1);
    }

    @Override
    public String getTileName() {
        return "spider";
    }
}
