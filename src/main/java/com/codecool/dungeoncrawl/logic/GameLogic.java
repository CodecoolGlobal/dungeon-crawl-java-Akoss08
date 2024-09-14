package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;

import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;

import java.util.*;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerStrength() {
        return Integer.toString(map.getPlayer().getAttackStrength());
    }

    public String getPlayerDefense() {
        return Integer.toString(map.getPlayer().getDefense());
    }

    public String getMonsterHealth() {
        Monster monster = map.getMonster();

        if (monster != null) {
            return Integer.toString(monster.getHealth());
        }

        return "";
    }

    public String getMonsterStrength() {
        Monster monster = map.getMonster();

        if (monster != null) {
            return Integer.toString(monster.getAttackStrength());
        }

        return "";
    }


    public String getMonsterAbility() {
        Monster monster = map.getMonster();

        if (monster != null) {
            return monster.getAbility();
        }

        return "";
    }

    public String getPlayerInventory() {
        return map.getPlayer().getInventory().toString();
    }

    public GameMap getMap() {
        return map;
    }

    public void moveMonsters() {
        map.moveMonsters();
        /*List<Actor> monsters = new ArrayList<>();
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Actor actor = map.getCell(x, y).getActor();
                if (actor != null && !(actor instanceof Player)) {
                    monsters.add(actor);
                }
            }
        }
        for (Actor monster : monsters) {
            moveRandomly(monster);
        }*/
    }

    private int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    private List<Cell> getWalkableCells(Actor monster) {
        List<Cell> monsterNeighbouringCells = monster.getCell().getNeighbors();
        List<Cell> walkableCells = new ArrayList<>();

        for (Cell cell : monsterNeighbouringCells) {
            if (cell.isWalkable()) {
                walkableCells.add(cell);
            }
        }
        return walkableCells;
    }

    private void moveRandomly(Actor monster) {
        List<Cell> walkableCells = getWalkableCells(monster);
        Cell nextCell = walkableCells.get(randomNumber(0, walkableCells.size()));
        int currentX = monster.getX();
        int currentY = monster.getY();
        int nextX = nextCell.getX();
        int nextY = nextCell.getY();

        monster.move(nextX - currentX, nextY - currentY);
    }
}
