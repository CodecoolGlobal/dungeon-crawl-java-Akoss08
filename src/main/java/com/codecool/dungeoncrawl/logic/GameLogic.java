package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.ArrayList;
import java.util.List;

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

    public String getMonsterHealth() {
        Cell[] neighbouringCells = new Cell[4];
        Cell playerCell = map.getPlayer().getCell();
        String monsterHealth = "";
        neighbouringCells[0] = playerCell.getNeighbor(1, 0);
        neighbouringCells[1] = playerCell.getNeighbor(-1, 0);
        neighbouringCells[2] = playerCell.getNeighbor(0, 1);
        neighbouringCells[3] = playerCell.getNeighbor(0, -1);

        Actor monster = null;
        for (Cell neighbouringCell : neighbouringCells) {
            if (neighbouringCell.getActor() != null) {
                monster = neighbouringCell.getActor();
            }
        }
        if (monster != null) {
            monsterHealth = Integer.toString(monster.getHealth());
        }
        return monsterHealth;
    }

    public String getPlayerInventory() {
        return map.getPlayer().getInventory().toString();
    }

    public GameMap getMap() {
        return map;
    }

    public void moveMonsters () {
        List<Actor> monsters = new ArrayList<>();
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Actor actor = map.getCell(x, y).getActor();
                if (actor != null && !(actor instanceof Player)) {
                    monsters.add(actor);
                }
            }
        }

        for (Actor monster : monsters) {
            monster.move(0, 1);
        }
    }

    private int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

}
