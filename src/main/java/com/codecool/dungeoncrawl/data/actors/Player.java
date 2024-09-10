package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Inventory;

public class Player extends Actor {
    private final Inventory inventory;

    public Player(Cell cell) {
        super(cell);
        setAttackStrength(5);
        this.inventory = new Inventory();
    }

    public String getTileName() {
        return "player";
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        pickUpItemIfAny();
    }

    private void pickUpItemIfAny() {
        boolean isItem = getCell().getItem() != null;

        if (isItem) {
            inventory.addItem(getCell().getItem());
            getCell().setItem(null);
        }
    }
}
