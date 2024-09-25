package com.codecool.dungeoncrawl.data.mapElements.npcs;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public abstract class Npc implements Drawable {
    protected String dialog;
    protected Cell cell;
    private final String tileName;

    public Npc(String dialog, Cell cell, String tileName) {
        this.dialog = dialog;
        this.cell = cell;
        this.cell.setNpc(this);
        this.tileName = tileName;
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public String getDialog() {
        return dialog;
    }

    public abstract void interact(Player player);
}
