package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        /*String[] monsters = {"skeleton"};
        for (String monster : monsters) {
            if (!nextCell.getType().equals(monster)) {
                if (!nextCell.getType().equals("wall")) {
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                }
            }
        }*/

        boolean isMonster = nextCell.getActor() instanceof Actor;
        if (!isMonster && !nextCell.getTileName().equals("wall")) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
