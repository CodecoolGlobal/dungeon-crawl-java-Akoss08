package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health;
    protected int attackStrength;
    private int defense;

    public Actor(Cell cell, int health, int attackStrength, int defense) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.attackStrength = attackStrength;
        this.defense = defense;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean isWalkable = cell.isWalkable(nextCell);

        if (isWalkable) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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
