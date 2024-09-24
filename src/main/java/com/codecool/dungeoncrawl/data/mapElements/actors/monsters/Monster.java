package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public abstract class Monster extends Actor {
    private String ability = "No special ability";
    private int droppedXp;

    public Monster(Cell cell, int health, int strength, String tileName, int droppedXp) {
        super(cell, health, strength, tileName);
        this.droppedXp = droppedXp;
    }

    public Monster(Cell cell, int health, int strength, String ability, String tileName, int droppedXp) {
        super(cell, health, strength, tileName);
        this.ability = ability;
        this.droppedXp = droppedXp;
    }

    public Monster(Cell cell, int health, int strength, int defense, String tileName, int droppedXp) {
        super(cell, health, strength, defense, tileName);
        this.droppedXp = droppedXp;
    }

    public Monster(Cell cell, int health, int strength, int defense, String ability, String tileName, int droppedXp) {
        super(cell, health, strength, defense, tileName);
        this.ability = ability;
        this.droppedXp = droppedXp;
    }

    public void attack(Player player) {
        if (health <= 0) {
            die();
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
