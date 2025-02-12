package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public class Chest implements Drawable {
    private final Item item;
    private boolean isOpen = false;

    public Chest(Cell cell, Item item) {
        cell.setChest(this);
        this.item = item;
    }

    @Override
    public String getTileName() {
        return isOpen ? "openChest" : "closedChest";
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Item openChest() {
        if(!isOpen) {
            isOpen = true;
            return item;
        }
        return null;
    }
}
