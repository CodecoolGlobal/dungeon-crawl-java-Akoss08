package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.items.SnakeTooth;

public class Snake extends Monster {
    private static final int BASE_HEALTH = 1;
    private static final int BASE_POWER = 1;
    private static final int XP_VALUE = 4;
    private static final String TILE_NAME = "snake";

    private final SnakeTooth snakeTooth;
    private static final int POISON_STRENGTH = 2;
    private static final int POISON_LENGTH = 2;

    public Snake(Cell cell, SnakeTooth snakeTooth) {
        super(cell, BASE_HEALTH, BASE_POWER, TILE_NAME, XP_VALUE);
        this.snakeTooth = snakeTooth;
    }

    @Override
    public void attack(Player player) {
        if (health <= 0) {
            die();
            player.collectXp(XP_VALUE);
            snakeTooth.addToPlayer(player);
        } else {
            poison(player);

            int playerHealth = player.getHealth();
            int monsterStrength = Math.max(attackStrength - player.getDefense(), 0);
            int playerNewHealth = playerHealth - monsterStrength;

            player.setHealth(playerNewHealth);
        }
    }

    private void poison(Player player) {
        player.setPoisoned(true);
        player.setPoisonDuration(POISON_LENGTH);
        player.setPoisonStrength(POISON_STRENGTH);
    }
}
