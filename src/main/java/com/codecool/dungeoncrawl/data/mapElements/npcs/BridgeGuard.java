package com.codecool.dungeoncrawl.data.mapElements.npcs;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class BridgeGuard extends Npc {
    private static final String BASE_DIALOG = "Halt, Traveler!\nThis bridge isn’t for just anyone. " +
            "You’ll need to earn\n" +
            "your way across. There are three snakes lurking\nnearby, each carrying poison in their " +
            "teeth. \n\nBring me their teeth, and only then will I let you pass." +
            "\nNo teeth, no crossing. Simple as that.";
    private static final String FAIL_DIALOG = "You think you can fool me, Traveler?\n" +
            "These are not all the teeth I asked for.\n" +
            "There are still snakes out there, and I want them\n" +
            "dealt with." +
            "\n\nReturn when you have all the teeth,\n" +
            "or there will be no crossing.";
    private static final String SUCCESS_DIALOG = "Ah, Traveler! You've done it.\n" +
            "All the snake teeth, just as I asked.\n" +
            "You have proven your worth,\n" +
            "and I will keep my word." +
            "\n\nGo ahead and cross the bridge.\n" +
            "Safe travels on your journey.";
    private static final String TILE_NAME = "guard";
    private boolean interactable = true;

    public BridgeGuard(Cell cell) {
        super(BASE_DIALOG, cell, TILE_NAME);
    }

    @Override
    public void interact(Player player) {
        int requiredTeeth = 3;
        if (interactable) {
            if (player.hasThreeTeeth(requiredTeeth)) {
                int goldForMission = 30;
                int xpForMission = 3;
                player.collectGold(goldForMission);
                player.collectXp(xpForMission);
                move();
                dialog = SUCCESS_DIALOG;
                interactable = false;
            } else {
                dialog = FAIL_DIALOG;
            }
        }
    }

    private void move() {
        Cell nextCell = cell.getNeighbor(0, 1);
        cell.setNpc(null);
        nextCell.setNpc(this);
        cell = nextCell;
    }
}
