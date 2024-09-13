package com.codecool.dungeoncrawl.data.mapElements.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public abstract class Item implements Drawable {
    private Cell cell;

    public Item(Cell cell) {
        this.cell = cell;
        if (cell != null) {
            this.cell.setItem(this);
        }
    }

    public Cell getCell() {
        return cell;
    }

    public abstract void setAbility(Player player);


}
