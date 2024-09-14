package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.Inventory;
import com.codecool.dungeoncrawl.data.mapElements.Chest;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Scorpion;
import com.codecool.dungeoncrawl.data.mapElements.items.*;

import java.util.List;

public class Player extends Actor {
    private static final int BASE_HEALTH = 10;
    private static final int BASE_POWER = 5;
    private static final int BASE_DEFENSE = 0;
    private String tileName;
    private final Inventory inventory;
    private PowerPotion powerBoost;
    private HealthPotion healthBoost;

    public Player(Cell cell, String tileName) {
        super(cell, BASE_HEALTH, BASE_POWER, BASE_DEFENSE, tileName);
        this.inventory = new Inventory();
        this.tileName = tileName;
        this.powerBoost = null;
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    public void setPowerBoost(PowerPotion powerBoost) {
        this.powerBoost = powerBoost;
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
        boolean isWalkable = getCell().isWalkable(nextCell);
        boolean isClosedDoor = nextCell.getType().equals(CellType.CLOSED_DOOR);

        if (isWalkable) {
            setNextMove(nextCell);
        } else if (isClosedDoor) {
            boolean doorOpened = tryOpenDoor(nextCell);

            if (doorOpened) {
                setNextMove(nextCell);
            }
        }
    }

    public void attack() {
        List<Cell> neighbors = getCell().getNeighbors();
        List<Monster> allMonsters = GameMap.getMonsters();

        for (Cell neighbor : neighbors) {
            Monster monster = (Monster) neighbor.getActor();

            if (monster != null) {
                attackMonster(neighbor, monster, allMonsters);
            }
        }
    }

    private void attackMonster(Cell neighbor, Monster monster, List<Monster> allMonsters) {
        if (powerBoost != null) {
            applyPowerUp();
        }

        int monsterHealth = monster.getHealth();
        int monsterNewHealth = monsterHealth - attackStrength;

        if (monsterNewHealth <= 0) {
            killMonster(neighbor, monster, allMonsters);
        } else {
            monster.setHealth(monsterNewHealth);
            monster.attack(this);
        }
    }

    private void killMonster(Cell neighbor, Monster monster, List<Monster> allMonsters) {
        if (monster instanceof Scorpion) {
            neighbor.setItem(new PowerPotion(neighbor));
        }
        neighbor.setActor(null);
        allMonsters.remove(monster);

        if (allMonsters.size() == 1) {
            neighbor.setItem(new Key(neighbor));
        }
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
            getCell().setItem(null);
            inventory.addItem(item);
            item.addToPlayer(this);
        }
    }

    public void openChest() {
        List<Cell> neighborsCell = getCell().getNeighbors();

        for (Cell neighbor : neighborsCell) {
            Chest chest = neighbor.getChest();

            if (chest != null && !chest.isOpen()) {
                chest.openChest();
                neighbor.setType(CellType.OPEN_CHEST);
                Item chestItem = chest.getItem();
                inventory.addItem(chestItem);
                chestItem.setAbility(this);
            }
        }
    }

    public void heal() {
        Item toRemove = null;

        for (Item item : inventory.getItems()) {
            if (item instanceof HealthPotion) {
                healthBoost = (HealthPotion) item;
                healthBoost.use(this);
                toRemove = item;
                healthBoost = null;
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
