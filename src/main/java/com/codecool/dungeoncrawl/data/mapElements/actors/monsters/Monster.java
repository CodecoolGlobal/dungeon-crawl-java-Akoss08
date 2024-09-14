package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import javafx.application.Platform;


public abstract class Monster extends Actor {
    private String ability = "No special ability";

    public Monster(Cell cell, int health, int strength, String tileName) {
        super(cell, health, strength, tileName);
    }

    public Monster(Cell cell, int health, int strength, String ability, String tileName) {
        super(cell, health, strength, tileName);
        this.ability = ability;
    }

    public Monster(Cell cell, int health, int strength, int defense, String tileName) {
        super(cell, health, strength, defense, tileName);
    }

    public Monster(Cell cell, int health, int strength, int defense, String ability, String tileName) {
        super(cell, health, strength, defense, tileName);
        this.ability = ability;
    }

    public void attack(Player player) {
        int playerHealth = player.getHealth();
        int monsterStrength = Math.max(getAttackStrength() - player.getDefense(), 0);

        int playerNewHealth = playerHealth - monsterStrength;

        if (playerNewHealth <= 0) {
            getCell().setActor(null);
            Platform.exit();
        } else {
            player.setHealth(playerNewHealth);
        }
    }

    public String getAbility() {
        return ability;
    }
}
