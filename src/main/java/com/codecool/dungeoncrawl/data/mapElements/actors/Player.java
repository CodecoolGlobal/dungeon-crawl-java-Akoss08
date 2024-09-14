package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.mapElements.Chest;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.items.*;
import javafx.application.Platform;

import java.util.List;

public class Player extends Actor {
    private static final int BASE_HEALTH = 10;
    private static final int BASE_POWER = 5;
    private static final int BASE_DEFENSE = 0;
    private final Inventory inventory;
    private PowerPotion powerBoost;

    public Player(Cell cell, String tileName) {
        super(cell, BASE_HEALTH, BASE_POWER, BASE_DEFENSE, tileName);
        this.inventory = new Inventory();
    }


    public Inventory getInventory() {
        return inventory;
    }

    public int getBaseHealth() {
        return BASE_HEALTH;
    }


    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean isClosedDoor = nextCell.getType().equals(CellType.CLOSED_DOOR);

        if (nextCell.isWalkable()) {
            setNextMove(nextCell);
        } else if (isClosedDoor) {
            boolean doorOpened = tryOpenDoor(nextCell);

            if (doorOpened) {
                setNextMove(nextCell);
            }
        }
    }

    public void attack() {
        List<Cell> neighbors = cell.getNeighbors();

        for (Cell neighbor : neighbors) {
            Actor monster = neighbor.getActor();

            if (monster instanceof Monster) {
                attackMonster((Monster) monster);
            }
        }
    }

    @Override
    protected void die() {
        super.die();
        Platform.exit();
    }

    ;

    private void attackMonster(Monster monster) {
        if (powerBoost != null) {
            applyPowerUp();
        }

        if (health <= 0) {
            die();
        }

        int monsterHealth = monster.getHealth();
        int playerStrength = Math.max(attackStrength - monster.getDefense(), 0);
        int monsterNewHealth = monsterHealth - playerStrength;

        monster.setHealth(monsterNewHealth);

        monster.attack(this);
    }

    private void applyPowerUp() {
        powerBoost.decreaseDuration();
        if (powerBoost.getDuration() == 0) {
            powerBoost.resetPowerBoost(this);
            powerBoost = null;
        }
    }

    private boolean tryOpenDoor(Cell nextCell) {
        if (inventory.getItems().removeIf(item -> item instanceof Key)) {
            nextCell.setType(CellType.OPEN_DOOR);
            return true;
        }

        return false;
    }

    private void setNextMove(Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
        pickUpItemIfAny();
    }

    private void pickUpItemIfAny() {
        Item item = cell.getItem();

        if (item != null) {
            cell.setItem(null);
            item.addToPlayer(this);
        }
    }

    public void openChest() {
        List<Cell> neighborsCell = cell.getNeighbors();

        for (Cell neighbor : neighborsCell) {
            Chest chest = neighbor.getChest();

            if (chest != null && !chest.isOpen()) {
                neighbor.setType(CellType.OPEN_CHEST);
                Item chestItem = chest.openChest();
                chestItem.addToPlayer(this);
            }
        }
    }

    public void heal() {
        Item toRemove = null;

        for (Item item : inventory.getItems()) {
            if (item instanceof HealthPotion) {
                HealthPotion healthBoost = (HealthPotion) item;
                healthBoost.use(this);
                toRemove = healthBoost;
                break;
            }
        }

        inventory.getItems().remove(toRemove);
    }

    public void powerUp() {
        Item toRemove = null;

        for (Item item : inventory.getItems()) {
            if (item instanceof PowerPotion) {
                powerBoost = (PowerPotion) item;
                powerBoost.use(this);
                toRemove = item;
                break;
            }
        }

        inventory.getItems().remove(toRemove);
    }


}
