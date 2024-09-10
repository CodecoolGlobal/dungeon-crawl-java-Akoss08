package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.logic.GameLogic;
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

        while (attackedHpAfterStrike - this.attackStrength > 0 && playerHpAfterStrike > 0) {

            attackedHpAfterStrike -= this.attackStrength;
            attackedActor.setHealth(attackedHpAfterStrike);
            playerHpAfterStrike -= attackedActor.getAttackStrength();
            this.health -= attackedActor.getAttackStrength();
        }
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean isMonster = nextCell.getActor() instanceof Actor;
        boolean isBorder = isBorder(nextCell);
        if (!isMonster && !nextCell.getTileName().equals("wall") && !isBorder) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    private  boolean isBorder (Cell cell) {
      GameMap map = MapLoader.loadMap();
      double mapWidth = map.getWidth();
      double mapHeight = map.getHeight();
      return cell.getX() <= 0
              || cell.getX() >= mapWidth - 1
              || cell.getY() <= 0
              || cell.getY() >= mapHeight - 1;
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

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
