package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Scorpion;
import com.codecool.dungeoncrawl.data.mapElements.items.PowerPotion;
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
                int monsterStrength = Math.max(monster.getAttackStrength() - this.getDefense(), 0);

                int monsterNewHealth = monsterHealth - this.getAttackStrength();
                int playerNewHealth = playerHealth - monsterStrength;

                if (monsterNewHealth <= 0) {
                    if (monster instanceof Scorpion) {
                        neighbor.setItem(new PowerPotion(neighbor));
                    }
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
