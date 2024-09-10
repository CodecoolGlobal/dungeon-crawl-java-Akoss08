package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Inventory;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.Sword;

public class Player extends Actor {
    private final Inventory inventory;

    public Player(Cell cell) {
        super(cell);
        this.inventory = new Inventory();
    }

    @Override
    public String getTileName() {
        if (inventory.getItems().stream().anyMatch(item -> item instanceof Sword)) {
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

        System.out.println(isMonster);
        System.out.println(isBorder);
        System.out.println(isClosedDoor);
        System.out.println(isWall);

        if (!isMonster && !isWall && !isBorder && !isClosedDoor) {
            setNextMove(nextCell);
        } else if (isClosedDoor) {
            boolean doorOpened = tryOpenDoor(nextCell);

            if (doorOpened) {
                setNextMove(nextCell);
            }
        }
    }

    private boolean tryOpenDoor(Cell nextCell) {
        if (inventory.getItems().stream().anyMatch(item -> item instanceof Key)) {
            inventory.getItems().removeIf(item -> item instanceof Key);
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
            inventory.addItem(getCell().getItem());
            getCell().setItem(null);
        }
    }
}
