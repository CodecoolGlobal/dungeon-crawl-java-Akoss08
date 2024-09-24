package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public abstract class Monster extends Actor {
    private String ability = "No special ability";
    private final int xpValue;

    public Monster(Cell cell, int health, int strength, String tileName, int xpValue) {
        super(cell, health, strength, tileName);
        this.xpValue = xpValue;
    }

    public Monster(Cell cell, int health, int strength, String ability, String tileName, int xpValue) {
        super(cell, health, strength, tileName);
        this.ability = ability;
        this.xpValue = xpValue;
    }

    public Monster(Cell cell, int health, int strength, int defense, String tileName, int xpValue) {
        super(cell, health, strength, defense, tileName);
        this.xpValue = xpValue;
    }

    public Monster(Cell cell, int health, int strength, int defense, String ability, String tileName,
                   int xpValue) {
        super(cell, health, strength, defense, tileName);
        this.ability = ability;
        this.xpValue = xpValue;
    }

    public void attack(Player player) {
        if (health <= 0) {
            die();
            player.collectXp(xpValue);
        } else {
            int playerHealth = player.getHealth();
            int monsterStrength = Math.max(attackStrength - player.getDefense(), 0);
            int playerNewHealth = playerHealth - monsterStrength;

            player.setHealth(playerNewHealth);
        }
    }

    public String getAbility() {
        return ability;
    }
}
