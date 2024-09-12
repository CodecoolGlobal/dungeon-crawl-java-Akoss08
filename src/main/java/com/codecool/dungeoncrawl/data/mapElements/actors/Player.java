package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Inventory;
import com.codecool.dungeoncrawl.data.mapElements.Chest;
import com.codecool.dungeoncrawl.data.mapElements.items.Item;
import com.codecool.dungeoncrawl.data.mapElements.items.Key;
import com.codecool.dungeoncrawl.data.mapElements.items.Shield;
import com.codecool.dungeoncrawl.data.mapElements.items.Sword;

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
        if (inventory.getItems().stream().anyMatch(item -> item instanceof Sword)) {
            if (inventory.getItems().stream().anyMatch(item -> item instanceof Shield)) {
                return "playerWithSwordAndShield";
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
        boolean isMonster = nextCell.getActor() != null;
        boolean isBorder = isBorder(nextCell);
        boolean isClosedDoor = nextCell.getTileName().equals("closedDoor");
        boolean isWall = nextCell.getTileName().equals("wall");
        boolean isChest = nextCell.getTileName().contains("Chest");

        if (!isMonster && !isWall && !isBorder && !isClosedDoor && !isChest) {
            setNextMove(nextCell);
        } else if (isClosedDoor) {
            boolean doorOpened = tryOpenDoor(nextCell);

            if (doorOpened) {
                setNextMove(nextCell);
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
}
