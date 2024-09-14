package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;
    protected int health;
    protected int attackStrength;
    protected int defense = 0;
    private String tileName;

    private boolean isDead = false;

    public Actor(Cell cell, int health, int attackStrength, String tileName) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.attackStrength = attackStrength;
        this.tileName = tileName;
    }

    public Actor(Cell cell, int health, int attackStrength, int defense, String tileName) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.attackStrength = attackStrength;
        this.defense = defense;
        this.tileName = tileName;
    }

    public boolean isDead() {
        return isDead;
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    protected void die() {
        cell.setActor(null);
        isDead = true;
    };

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (nextCell.isWalkable()) {
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
