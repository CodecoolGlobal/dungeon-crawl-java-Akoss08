package com.codecool.dungeoncrawl.data.mapElements;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.mapElements.items.Item;

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

    public Item getItem() {
        return item;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void openChest() {
        isOpen = true;
    }
}
