package com.codecool.dungeoncrawl.data.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class Scorpion extends Monster {


    public Scorpion(Cell cell) {
        super(cell);
        setAttackStrength(5);
        setHealth(5);
    }

    @Override
    public String getTileName() {
        return "scorpion";
    }
}
