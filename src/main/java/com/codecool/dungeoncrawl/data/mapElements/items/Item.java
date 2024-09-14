package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public abstract class Item implements Drawable {
    private final Cell cell;

    private final String tileName;

    public Item(Cell cell, String tileName) {
        this.cell = cell;
        this.tileName = tileName;
        if (cell != null) {
            this.cell.setItem(this);
        }
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public Cell getCell() {
        return cell;
    }

    public abstract void setAbility(Player player);


}
