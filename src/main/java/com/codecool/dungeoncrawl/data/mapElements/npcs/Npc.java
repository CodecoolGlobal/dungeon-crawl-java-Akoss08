package com.codecool.dungeoncrawl.data.mapElements.npcs;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Npc implements Drawable {
    private final String dialog;
    private final Cell cell;
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
}
