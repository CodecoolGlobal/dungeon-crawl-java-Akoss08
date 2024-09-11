package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Actor {

    public Skeleton(Cell cell) {
        super(cell);
        setAttackStrength(2);
        setHealth(10);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

   /* @Override
    public void move(int dx, int dy) {
        Cell nextCell = this.getCell().getNeighbor(dx, dy);
        boolean isMonster = nextCell.getActor() != null;
        boolean isBorder = isBorder(nextCell);
        boolean isWall = nextCell.getTileName().equals("wall");
        boolean isClosedDoor = nextCell.getTileName().equals("closedDoor");

        if (!isMonster && !isWall && !isBorder && !isClosedDoor) {
            this.getCell().setActor(null);
            nextCell.setActor(this);
            this.setCell(nextCell);
        }
    }*/
}
