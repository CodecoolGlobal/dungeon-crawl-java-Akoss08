package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Effect;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.PoisonEffect;
import com.codecool.dungeoncrawl.data.mapElements.items.SnakeTooth;

public class Snake extends Monster {
    private static final int BASE_HEALTH = 15;
    private static final int BASE_POWER = 5;
    private static final int XP_VALUE = 4;
    private static final String TILE_NAME = "snake";
    private final SnakeTooth snakeTooth;
    private static final int POISON_STRENGTH = 1;
    private static final int POISON_LENGTH = 2;
    private static final String ABILITY = "Snakes are poisonous, their poison deal 1 damage\n" +
            "for 2 moves";
    private static final Effect POISON = new PoisonEffect(2,1);

    public Snake(Cell cell, SnakeTooth snakeTooth) {
        super(cell, BASE_HEALTH, BASE_POWER, ABILITY, TILE_NAME, XP_VALUE);
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
        player.applyEffect(POISON);
    }
}
