package com.codecool.dungeoncrawl.data.mapElements.npcs;

import com.codecool.dungeoncrawl.data.Cell;

public class BridgeGuard extends Npc {
    private static final String DIALOG = "Halt, Traveler!\nThis bridge isn’t for just anyone. " +
            "You’ll need to earn\n" +
            "your way across. There are three snakes lurking\nnearby, each carrying poison in their " +
            "teeth. \n\nBring me their teeth, and only then will I let you pass." +
            "\nNo teeth, no crossing. Simple as that.";
    private static final String TILE_NAME = "guard";

    public BridgeGuard(Cell cell) {
        super(DIALOG, cell, TILE_NAME);
    }
}
