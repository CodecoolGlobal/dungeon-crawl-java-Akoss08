package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMaps.GameMap;

import java.util.List;
import java.util.Random;

public abstract class Moopsy extends Monster {

    public Moopsy(
            Cell cell,
            int health,
            int strength,
            String ability,
            String tileName,
            int xpValue
    ) {
        super(cell, health, strength, ability, tileName, xpValue);
    }

    @Override
    public void move(int dx, int dy) {
        boolean isTeleporting = Math.random() <= 0.1;

        if (isTeleporting) {
            teleport();
        } else {
            super.move(dx, dy);
        }
    }

    protected void teleport() {
        GameMap map = getCell().getGameMap();
        List<Cell> walkableCells = map.getWalkableCellsForMoopsy();
        Random random = new Random();
        Cell nextCell = walkableCells.get(random.nextInt(walkableCells.size()));
        if (nextCell.isWalkable()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public abstract boolean isHalfHP();

    public abstract Moopsy[] split();
}

