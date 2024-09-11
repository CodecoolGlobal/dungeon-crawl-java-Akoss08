package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private int attackStrength;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void attack (Actor attackedActor) {
        int attackedHpAfterStrike = attackedActor.getHealth();
        int playerHpAfterStrike = this.health;

        while (attackedHpAfterStrike - this.attackStrength >= 0 && playerHpAfterStrike > 0) {

            attackedHpAfterStrike -= this.attackStrength;
            attackedActor.setHealth(attackedHpAfterStrike);
            playerHpAfterStrike -= attackedActor.getAttackStrength();
            this.health -= attackedActor.getAttackStrength();
        }
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean isMonster = nextCell.getActor() != null;
        boolean isBorder = isBorder(nextCell);
        boolean isWall = nextCell.getTileName().equals("wall");
        boolean isClosedDoor = nextCell.getTileName().equals("closedDoor");

        if (!isMonster && !isWall && !isBorder && !isClosedDoor) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public boolean isBorder(Cell cell) {
        GameMap map = MapLoader.loadMap();
        double mapWidth = map.getWidth();
        double mapHeight = map.getHeight();
        return cell.getX() <= 0
                || cell.getX() >= mapWidth
                || cell.getY() <= 0
                || cell.getY() >= mapHeight;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
