package com.codecool.dungeoncrawl.data.mapElements.items.weapons;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.items.Item;

public abstract class Weapon extends Item {
    private final int damage;

    public Weapon(int price, int damage) {
        super(price);
        this.damage = damage;
    }

    public Weapon(Cell cell, String tileName, int damage) {
        super(cell, tileName);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
