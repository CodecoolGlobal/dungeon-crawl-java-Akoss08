package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Inventory;
import com.codecool.dungeoncrawl.data.mapElements.Chest;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Scorpion;
import com.codecool.dungeoncrawl.data.mapElements.items.*;

import java.util.List;

public class Player extends Actor {
    private final Inventory inventory;

    public Player(Cell cell) {
        super(cell);
        setAttackStrength(5);
        setDefense(0);
        this.inventory = new Inventory();
    }

    @Override
    public String getTileName() {
        boolean hasSword = inventory.getItems().stream().anyMatch(item -> item instanceof Sword);
        boolean hasShield = inventory.getItems().stream().anyMatch(item -> item instanceof Shield);
        boolean hasHelmet = inventory.getItems().stream().anyMatch(item -> item instanceof Helmet);

        if (hasSword) {
            if (hasShield) {
                return hasHelmet ? "playerWithSwordAndShieldAndHelmet" : "playerWithSwordAndShield";
            }
            return "playerWithSword";
        }
        return "player";
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = getCell().getNeighbor(dx, dy);
        boolean isWalkable = getCell().isWalkable(nextCell);
        boolean isClosedDoor = nextCell.getTileName().equals("closedDoor");

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

        for (Cell neighbor : neighbors) {
            Monster monster = (Monster) neighbor.getActor();

            if (monster != null) {
                int monsterHealth = monster.getHealth();

                int monsterNewHealth = monsterHealth - getAttackStrength();

                if (monsterNewHealth <= 0) {
                    if (monster instanceof Scorpion) {
                        neighbor.setItem(new PowerPotion(neighbor));
                    }
                    neighbor.setActor(null);
                } else {
                    monster.setHealth(monsterNewHealth);
                    monster.attack(this);
                }
            }
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
        getCell().setActor(null);
        nextCell.setActor(this);
        setCell(nextCell);
        pickUpItemIfAny();
    }

    private void pickUpItemIfAny() {
        boolean isItem = getCell().getItem() != null;

        if (isItem) {
            Item item = getCell().getItem();
            inventory.addItem(item);
            getCell().setItem(null);
            item.setAbility(this);
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
                inventory.addItem(chest.getItem());
                chestItem.setAbility(this);
            }
        }
    }

    public void heal() {
        if (inventory.getItems().removeIf(item -> item instanceof HealthPotion)) {
            this.setHealth(10);
        }
    }

    public void powerUp() {
        if (inventory.getItems().removeIf(item -> item instanceof PowerPotion)) {
            this.setAttackStrength(10);
        }
    }

}
