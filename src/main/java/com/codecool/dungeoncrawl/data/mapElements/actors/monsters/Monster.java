package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import javafx.application.Platform;


public abstract class Monster extends Actor {
    public Monster(Cell cell) {
        super(cell);
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
        return "";
    }
}
