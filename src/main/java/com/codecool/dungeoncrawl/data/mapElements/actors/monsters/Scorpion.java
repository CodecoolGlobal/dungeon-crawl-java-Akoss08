package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class Scorpion extends Monster {

    public Scorpion(Cell cell, int health, int strength, int defense) {
        super(cell, health, strength, defense);
    }

    @Override
    public String getTileName() {
        return "scorpion";
    }
}
