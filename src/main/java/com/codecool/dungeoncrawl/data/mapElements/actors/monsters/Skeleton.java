package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Monster {

    public Skeleton(Cell cell) {
        super(cell);
        setAttackStrength(4);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
