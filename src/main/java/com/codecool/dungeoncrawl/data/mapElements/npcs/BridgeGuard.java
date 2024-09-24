package com.codecool.dungeoncrawl.data.mapElements.npcs;

import com.codecool.dungeoncrawl.data.Cell;

public class BridgeGuard extends Npc {
    private static final String DIALOG = "Halt, Traveler! This bridge isn’t for just anyone. " +
            "You’ll need to earn your way across.\n" +
            "There are three snakes lurking nearby, each carrying poison in their teeth. " +
            "Bring me their teeth, and only then will I let you pass.\n" +
            "No teeth, no crossing. Simple as that.";
    private static final String TILE_NAME = "guard";

    public BridgeGuard(Cell cell) {
        super(DIALOG, cell, TILE_NAME);
    }
}
