package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import javafx.application.Platform;

import java.util.List;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private int attackStrength;
    private int defense;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void attack() {
        List<Cell> neighbors = cell.getNeighbors();

        for (Cell neighbor : neighbors) {
            Actor monster = neighbor.getActor();

            if (monster != null) {
                int monsterHealth = monster.getHealth();
                int playerHealth = this.getHealth();

                int monsterNewHealth = monsterHealth - this.getAttackStrength();
                int playerNewHealth = playerHealth - (monster.getAttackStrength() - this.getDefense());

                if (monsterNewHealth <= 0) {
                    neighbor.setActor(null);
                } else {
                    monster.setHealth(monsterNewHealth);
                }

                if (playerNewHealth <= 0) {
                    cell.setActor(null);
                    Platform.exit();
                    break;
                } else {
                    this.setHealth(playerNewHealth);
                }
            }
        }
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean isMonster = nextCell.getActor() != null;
        boolean isBorder = isBorder(nextCell);
        boolean isWall = nextCell.getTileName().equals("wall");
        boolean isClosedDoor = nextCell.getTileName().equals("closedDoor");
        boolean isChest = nextCell.getTileName().equals("closedChest");

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
