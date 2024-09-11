package com.codecool.dungeoncrawl.data.mapElements;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.mapElements.items.Item;

public class Chest implements Drawable {
    private boolean isOpen;
    private final Item item;

    public Chest(Cell cell, Item item) {
        cell.setChest(this);
        this.item = item;
    }

    @Override
    public String getTileName() {
        return "chest";
    }

    public void open() {
        isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Item getItem() {
        return item;
    }
}
